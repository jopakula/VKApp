package com.example.vkapp.domain.di

import com.example.vkapp.domain.usecases.AuthenticateUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<AuthenticateUserUseCase> {
        AuthenticateUserUseCase(repository = get())
    }
}
