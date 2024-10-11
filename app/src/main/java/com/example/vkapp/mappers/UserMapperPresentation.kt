package com.example.vkapp.mappers

import com.example.vkapp.domain.models.DomainAuthenticationRequestModel
import com.example.vkapp.domain.models.DomainUserModel
import com.example.vkapp.network.models.AuthenticationRequestModelPresentation
import com.example.vkapp.network.models.UserModelPresentation

class UserMapperPresentation {
    companion object{
        fun mapDomainUserToPresentation(user: DomainUserModel): UserModelPresentation {
            return UserModelPresentation(
                id = user.id,
                username = user.username,
                email = user.email,
                firstName = user.firstName,
                lastName = user.lastName,
                gender = user.gender,
                image = user.image,
            )
        }
        fun mapPresentationAuthenticationRequestToDomain(request: AuthenticationRequestModelPresentation): DomainAuthenticationRequestModel {
            return DomainAuthenticationRequestModel(
                username = request.username,
                password = request.password,
            )
        }
    }
}