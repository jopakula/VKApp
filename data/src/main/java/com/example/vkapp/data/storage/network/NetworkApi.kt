package com.example.vkapp.data.storage.network

import com.example.vkapp.data.storage.models.DataAuthenticationRequestModel
import com.example.vkapp.data.storage.models.DataUserModel
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkApi {
    @POST("auth/login")
    suspend fun authentication(@Body authenticationRequest: DataAuthenticationRequestModel): DataUserModel
}