package com.example.vkapp.data.storage.user

import com.example.vkapp.data.storage.UserStorage
import com.example.vkapp.data.storage.models.DataUserModel

class UserStorageImplementation: UserStorage {

    private var userData =  DataUserModel(id = 0, username = "", email = "", firstName = "", lastName = "", gender = "", image = "")

    override suspend fun saveUser(user: DataUserModel) {
        userData = user
    }

    override suspend fun getUser(): DataUserModel {
        return userData
    }
}