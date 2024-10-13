package com.example.vkapp.data.storage.network

import com.example.vkapp.data.storage.NetworkStorage
import com.example.vkapp.data.storage.models.DataAuthenticationRequestModel
import com.example.vkapp.data.storage.models.DataPostsResponse
import com.example.vkapp.data.storage.models.DataUserModel

class NetworkStorageImplementation(private val networkApi: NetworkApi): NetworkStorage {
    override suspend fun authenticateUser(authenticationRequest: DataAuthenticationRequestModel): DataUserModel {
        return networkApi.authentication(authenticationRequest = authenticationRequest)
    }

    override suspend fun getPosts(): DataPostsResponse {
        return networkApi.getPosts()
    }
}