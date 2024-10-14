package com.example.vkapp.data.storage.network

import com.example.vkapp.data.storage.NetworkStorage
import com.example.vkapp.data.storage.models.DataAuthenticationRequestModel
import com.example.vkapp.data.storage.models.DataPostModel
import com.example.vkapp.data.storage.models.DataReactionsRequestModel
import com.example.vkapp.data.storage.models.DataPostsResponse
import com.example.vkapp.data.storage.models.DataUserModel

class NetworkStorageImplementation(private val networkApi: NetworkApi): NetworkStorage {
    override suspend fun authenticateUser(authenticationRequest: DataAuthenticationRequestModel): DataUserModel {
        return networkApi.authentication(authenticationRequest = authenticationRequest)
    }

    override suspend fun getPosts(): DataPostsResponse {
        return networkApi.getPosts()
    }

    override suspend fun getPostById(postId: Int): DataPostModel {
        return networkApi.getPostsById(postId = postId)
    }

    override suspend fun updatePost(postId: Int, updateRequest: DataReactionsRequestModel): DataPostModel {
        return networkApi.updatePost(postId = postId, updateRequest = updateRequest)
    }
}