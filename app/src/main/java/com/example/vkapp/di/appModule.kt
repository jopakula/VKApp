package com.example.vkapp.di

import com.example.vkapp.ui.viewModels.AuthenticationScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        AuthenticationScreenViewModel(
            authenticateUserUseCase = get(),
            saveUserUseCase = get(),
            getUserUseCase = get(),
        )
    }
}