package com.example.vkapp.di

import com.example.vkapp.ui.viewModels.AuthenticationScreenViewModel
import com.example.vkapp.ui.viewModels.MainScreenViewModel
import com.example.vkapp.ui.viewModels.ProfileScreenViewModel
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
    viewModel{
        MainScreenViewModel(
            getUserUseCase = get(),
            getPostsUseCase = get()
        )
    }
    viewModel{
        ProfileScreenViewModel(
            getUserUseCase = get()
        )
    }
}