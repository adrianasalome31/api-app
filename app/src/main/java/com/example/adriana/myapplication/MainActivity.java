package com.example.adriana.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.adriana.myapplication.Api.Api;
import com.example.adriana.myapplication.Api.ApiInterface;
import com.example.adriana.myapplication.models.Student;

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

        Student student = new Student();
        student.setName("Alejo");
        student.setSurname("Hernandez");
        student.setAge(19);

        Call<Student> studentCall = apiInterface.createStudent(student);
        studentCall.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {

                Log.i(TAG, response.body().getName());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

            }
        });

        Log.i(TAG,  apiInterface.getStudents().request().url().toString());


    }




}
