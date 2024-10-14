package com.example.vkapp.domain.usecases

import com.example.vkapp.domain.models.DomainPostsResponse
import com.example.vkapp.domain.repository.Repository

class GetPostsUseCase(private val repository: Repository) {
    suspend fun execute(): DomainPostsResponse {
        return repository.getPosts()
    }
}