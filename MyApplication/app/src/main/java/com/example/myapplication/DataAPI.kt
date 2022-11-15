package com.example.myapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DataAPI {
    @GET("smartphones")
    fun getDummyData(): Call<DummyData>
}