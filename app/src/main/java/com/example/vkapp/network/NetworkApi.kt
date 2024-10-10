package com.example.vkapp.network

import com.example.vkapp.network.models.AuthenticationRequest
import com.example.vkapp.network.models.User
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkApi {

    @POST("auth/login")
    suspend fun authentication(@Body authenticationRequest: AuthenticationRequest): User
}