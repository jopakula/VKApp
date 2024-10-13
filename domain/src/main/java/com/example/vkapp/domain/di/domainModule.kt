package com.example.vkapp.domain.di

import com.example.vkapp.domain.usecases.AuthenticateUserUseCase
import com.example.vkapp.domain.usecases.GetPostsUseCase
import com.example.vkapp.domain.usecases.GetUserUseCase
import com.example.vkapp.domain.usecases.SaveUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<AuthenticateUserUseCase> {
        AuthenticateUserUseCase(repository = get())
    }
    factory<GetUserUseCase> {
        GetUserUseCase(repository = get())
    }
    factory<SaveUserUseCase> {
        SaveUserUseCase(repository = get())
    }
    factory<GetPostsUseCase> {
        GetPostsUseCase(repository = get())
    }
}
