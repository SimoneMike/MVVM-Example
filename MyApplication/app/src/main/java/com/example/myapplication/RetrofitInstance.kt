package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : DataAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/products/category/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataAPI::class.java)
    }
}