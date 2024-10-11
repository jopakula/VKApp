package com.example.vkapp.domain.repository

import com.example.vkapp.domain.models.DomainAuthenticationRequestModel
import com.example.vkapp.domain.models.DomainUserModel

interface Repository {
    suspend fun authenticateUser(authenticationRequest: DomainAuthenticationRequestModel): DomainUserModel
}