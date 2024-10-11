package com.example.vkapp.data.repository

import com.example.vkapp.data.mappers.UserMapperData
import com.example.vkapp.data.storage.NetworkStorage
import com.example.vkapp.domain.models.DomainAuthenticationRequestModel
import com.example.vkapp.domain.models.DomainUserModel
import com.example.vkapp.domain.repository.Repository

class RepositoryImplementation(
    private val networkStorage: NetworkStorage
): Repository {
    override suspend fun authenticateUser(authenticationRequest: DomainAuthenticationRequestModel): DomainUserModel {
        val authenticationRequestData = UserMapperData.mapDomainAuthenticationRequestToData(authenticationRequest)
        val authenticateUserData = networkStorage.authenticateUser(authenticationRequest = authenticationRequestData)
        return UserMapperData.mapDataUserToDomain(authenticateUserData)
    }
}