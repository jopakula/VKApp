package com.example.vkapp.data.storage

import com.example.vkapp.data.storage.models.DataAuthenticationRequestModel
import com.example.vkapp.data.storage.models.DataUserModel

interface NetworkStorage {
    suspend fun authenticateUser(authenticationRequest: DataAuthenticationRequestModel): DataUserModel
}