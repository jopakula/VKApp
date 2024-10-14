package com.example.vkapp.data.storage

import com.example.vkapp.data.storage.models.DataAuthenticationRequestModel
import com.example.vkapp.data.storage.models.DataPostModel
import com.example.vkapp.data.storage.models.DataReactionsRequestModel
import com.example.vkapp.data.storage.models.DataPostsResponse
import com.example.vkapp.data.storage.models.DataUserModel

interface NetworkStorage {
    suspend fun authenticateUser(authenticationRequest: DataAuthenticationRequestModel): DataUserModel

    suspend fun getPosts(): DataPostsResponse

    suspend fun getPostById(postId: Int): DataPostModel

    suspend fun updatePost(postId: Int, reactionsRequestModel: DataReactionsRequestModel): DataPostModel

}