package com.example.vkapp.data.storage

import com.example.vkapp.data.storage.models.DataUserModel

interface UserStorage {
    suspend fun saveUser(user: DataUserModel)

    suspend fun getUser(): DataUserModel
}