package com.example.vkapp.data.repository

import com.example.vkapp.data.mappers.PostMapperData
import com.example.vkapp.data.mappers.UserMapperData
import com.example.vkapp.data.storage.NetworkStorage
import com.example.vkapp.data.storage.UserStorage
import com.example.vkapp.domain.models.DomainAuthenticationRequestModel
import com.example.vkapp.domain.models.DomainPostModel
import com.example.vkapp.domain.models.DomainReactionsRequestModel
import com.example.vkapp.domain.models.DomainPostsResponse
import com.example.vkapp.domain.models.DomainUserModel
import com.example.vkapp.domain.repository.Repository

class RepositoryImplementation(
    private val networkStorage: NetworkStorage,
    private val userStorage: UserStorage,
) : Repository {
    override suspend fun authenticateUser(authenticationRequest: DomainAuthenticationRequestModel): DomainUserModel {
        val authenticationRequestData = UserMapperData.mapDomainAuthenticationRequestToData(request = authenticationRequest)
        val authenticateUserData = networkStorage.authenticateUser(authenticationRequest = authenticationRequestData)
        return UserMapperData.mapDataUserToDomain(user = authenticateUserData)
    }

    override suspend fun saveUser(user: DomainUserModel) {
        val userData = UserMapperData.mapDomainUserToData(user = user)
        userStorage.saveUser(user = userData)
    }

    override suspend fun getUser(): DomainUserModel {
        val userDomain = userStorage.getUser()
        return UserMapperData.mapDataUserToDomain(user = userDomain)
    }

    override suspend fun getPosts(): DomainPostsResponse {
        val postResponse = networkStorage.getPosts()
        return PostMapperData.mapDataPostResponseToDomain(posts = postResponse)
    }

    override suspend fun getPostById(postId: Int): DomainPostModel {
        val postData = networkStorage.getPostById(postId = postId)
        return PostMapperData.mapDataPostToDomain(post = postData)
    }

    override suspend fun updatePost(
        postId: Int,
        reactionsRequestModel: DomainReactionsRequestModel
    ): DomainPostModel {
        val dataReactionsRequestModel = PostMapperData.mapDomainPostReactionsRequestToData(requestModel = reactionsRequestModel)

        val updatedPostResponse = networkStorage.updatePost(postId, dataReactionsRequestModel)
        return PostMapperData.mapDataPostToDomain(updatedPostResponse)
    }

}
