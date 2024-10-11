package com.example.vkapp.data.di

import com.example.vkapp.data.repository.RepositoryImplementation
import com.example.vkapp.data.storage.NetworkStorage
import com.example.vkapp.data.storage.UserStorage
import com.example.vkapp.data.storage.network.HttpClient
import com.example.vkapp.data.storage.network.NetworkApi
import com.example.vkapp.data.storage.network.NetworkStorageImplementation
import com.example.vkapp.data.storage.user.UserStorageImplementation
import com.example.vkapp.domain.repository.Repository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> { UserStorageImplementation() }
    single<NetworkApi> { HttpClient.api }
    single<NetworkStorage> { NetworkStorageImplementation(networkApi = get()) }
    single<Repository> { RepositoryImplementation(networkStorage = get(), userStorage = get())  }
}