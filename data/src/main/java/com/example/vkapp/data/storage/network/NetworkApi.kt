package com.example.vkapp.data.storage.network

import com.example.vkapp.data.storage.models.DataAuthenticationRequestModel
import com.example.vkapp.data.storage.models.DataPostModel
import com.example.vkapp.data.storage.models.DataPostsResponse
import com.example.vkapp.data.storage.models.DataUserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkApi {
    @POST("auth/login")
    suspend fun authentication(@Body authenticationRequest: DataAuthenticationRequestModel): DataUserModel

    @GET("posts")
    suspend fun getPosts(): DataPostsResponse

    @GET("posts/{id}")
    suspend fun getPostsById(@Path("id") postId: Int): DataPostModel
}