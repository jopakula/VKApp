package com.example.vkapp.data.storage

import com.example.vkapp.data.storage.models.DataAuthenticationRequestModel
import com.example.vkapp.data.storage.models.DataPostModel
import com.example.vkapp.data.storage.models.DataPostsResponse
import com.example.vkapp.data.storage.models.DataUserModel
import com.example.vkapp.domain.models.DomainPostModel

interface NetworkStorage {
    suspend fun authenticateUser(authenticationRequest: DataAuthenticationRequestModel): DataUserModel

    suspend fun getPosts(): DataPostsResponse

    suspend fun getPostById(postId: Int): DataPostModel
}