package com.example.adriana.myapplication.Api;

import com.example.adriana.myapplication.models.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;




 public interface ApiInterface {

    @GET("personas")
    Call<List<Persona>>getPersonas();

    @POST("personas")
    Call<Persona> createPersona(@Body Persona persona);




}
