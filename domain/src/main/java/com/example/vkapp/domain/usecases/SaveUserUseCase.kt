package com.example.vkapp.domain.usecases

import com.example.vkapp.domain.models.DomainUserModel
import com.example.vkapp.domain.repository.Repository

class SaveUserUseCase(private val repository: Repository) {
    suspend fun execute(user: DomainUserModel){
        return repository.saveUser(user)
    }
}