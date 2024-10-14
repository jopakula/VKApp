package com.example.vkapp.domain.repository

import com.example.vkapp.domain.models.DomainAuthenticationRequestModel
import com.example.vkapp.domain.models.DomainPostModel
import com.example.vkapp.domain.models.DomainPostsResponse
import com.example.vkapp.domain.models.DomainUserModel

interface Repository {
    suspend fun authenticateUser(authenticationRequest: DomainAuthenticationRequestModel): DomainUserModel

    suspend fun saveUser(user: DomainUserModel)

    suspend fun getUser(): DomainUserModel

    suspend fun getPosts(): DomainPostsResponse

    suspend fun getPostById(postId: Int):DomainPostModel
}