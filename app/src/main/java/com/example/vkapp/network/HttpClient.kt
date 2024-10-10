package com.example.vkapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClient {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val api: NetworkApi? = retrofit.create(NetworkApi::class.java)
}