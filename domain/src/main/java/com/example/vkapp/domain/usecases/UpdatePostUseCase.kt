package com.example.vkapp.domain.usecases

import com.example.vkapp.domain.models.DomainPostModel
import com.example.vkapp.domain.models.DomainReactionsRequestModel
import com.example.vkapp.domain.repository.Repository

class UpdatePostUseCase(private val repository: Repository) {
    suspend fun execute(postId: Int, reactionsRequestModel: DomainReactionsRequestModel): DomainPostModel {
        return repository.updatePost(postId = postId, reactionsRequestModel = reactionsRequestModel)
    }
}