package com.example.vkapp.domain.usecases

import com.example.vkapp.domain.models.DomainPostModel
import com.example.vkapp.domain.repository.Repository

class GetPostByIdUseCase(private val repository: Repository) {

    suspend fun execute(postId: Int): DomainPostModel {
        return repository.getPostById(postId)
    }
}
