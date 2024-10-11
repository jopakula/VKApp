package com.example.vkapp.domain.usecases

import com.example.vkapp.domain.models.DomainUserModel
import com.example.vkapp.domain.repository.Repository

class GetUserUseCase(private val repository: Repository) {
    suspend fun execute(): DomainUserModel{
        return repository.getUser()
    }
}