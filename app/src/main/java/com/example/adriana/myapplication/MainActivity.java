package com.example.adriana.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.adriana.myapplication.Api.Api;
import com.example.adriana.myapplication.Api.ApiInterface;
import com.example.adriana.myapplication.models.Persona;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.getBase())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Persona persona = new Persona();
        persona.setNombre("Alejo");
        persona.setApellido("Hernandez");
        persona.setEdad(19);

        Call<Persona> personaCall = apiInterface.createPersona(persona);
        personaCall.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {

                Log.i(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {

            }
        });

        Log.i(TAG,  apiInterface.getPersonas().request().url().toString());


    }




}
