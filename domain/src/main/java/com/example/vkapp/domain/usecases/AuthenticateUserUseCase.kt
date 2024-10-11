package com.example.vkapp.domain.usecases

import com.example.vkapp.domain.models.DomainAuthenticationRequestModel
import com.example.vkapp.domain.models.DomainUserModel
import com.example.vkapp.domain.repository.Repository

class AuthenticateUserUseCase(private val repository: Repository) {
    suspend fun execute(authenticationRequest: DomainAuthenticationRequestModel): DomainUserModel {
        return repository.authenticateUser(authenticationRequest)
    }
}

