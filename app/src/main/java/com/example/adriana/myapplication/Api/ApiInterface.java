package com.example.adriana.myapplication.Api;

import com.example.adriana.myapplication.models.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;




 public interface ApiInterface {

    @GET("students")
    Call<List<Student>>getStudents();

    @POST("students")
    Call<Student> createStudent(@Body Student student);




}
