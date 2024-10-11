package com.example.vkapp.data.mappers

import com.example.vkapp.data.storage.models.DataAuthenticationRequestModel
import com.example.vkapp.data.storage.models.DataUserModel
import com.example.vkapp.domain.models.DomainAuthenticationRequestModel
import com.example.vkapp.domain.models.DomainUserModel

class UserMapperData {
    companion object{
        fun mapDataUserToDomain(user: DataUserModel): DomainUserModel{
            return DomainUserModel(
                id = user.id,
                username = user.username,
                email = user.email,
                firstName = user.firstName,
                lastName = user.lastName,
                gender = user.gender,
                image = user.image,
            )
        }
        fun mapDomainUserToData(user: DomainUserModel): DataUserModel{
            return DataUserModel(
                id = user.id,
                username = user.username,
                email = user.email,
                firstName = user.firstName,
                lastName = user.lastName,
                gender = user.gender,
                image = user.image,
            )
        }
        fun mapDomainAuthenticationRequestToData(request: DomainAuthenticationRequestModel): DataAuthenticationRequestModel{
            return DataAuthenticationRequestModel(
                username = request.username,
                password = request.password,
            )
        }
    }
}