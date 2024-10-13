package com.example.vkapp.mappers

import com.example.vkapp.domain.models.DomainAuthenticationRequestModel
import com.example.vkapp.domain.models.DomainUserModel
import com.example.uikit.models.AuthenticationRequestModel
import com.example.uikit.models.UserModel

class UserMapperPresentation {
    companion object{
        fun mapDomainUserToPresentation(user: DomainUserModel): UserModel {
            return UserModel(
                id = user.id,
                username = user.username,
                email = user.email,
                firstName = user.firstName,
                lastName = user.lastName,
                gender = user.gender,
                image = user.image,
            )
        }
        fun mapPresentationAuthenticationRequestToDomain(request: AuthenticationRequestModel): DomainAuthenticationRequestModel {
            return DomainAuthenticationRequestModel(
                username = request.username,
                password = request.password,
            )
        }
    }
}