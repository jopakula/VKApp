package com.example.vkapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.button.MyButton
import com.example.uikit.inputField.MyInputField
import com.example.vkapp.navigation.Screens
import com.example.vkapp.ui.viewModels.AuthenticationScreenViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthenticationScreen(
    viewModel: AuthenticationScreenViewModel = koinViewModel(),
    navigationController: NavController,
) {
    val user by viewModel.user.observeAsState()
    val errorMessage by viewModel.errorMessage.observeAsState(null)
    val login by viewModel.login.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val loading by viewModel.loading.observeAsState(false)

    LaunchedEffect(user, errorMessage) {
        if (user != null && errorMessage == null) {
            delay(1000)
            navigationController.navigate(Screens.Main.screen)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MyInputField(
                text = login,
                onValueChange = { viewModel.login.value = it },
                showIconSearch = false,
                hint = "Введите логин",
                borderWidth = 0.dp
            )
            MyInputField(
                text = password,
                onValueChange = { viewModel.password.value = it },
                showIconSearch = false,
                hint = "Введите пароль",
                borderWidth = 0.dp
            )
            MyButton(
                buttonText = if (loading) "Загрузка..." else "Войти",
                onClick = {
                    viewModel.clearErrorMessage()
                    viewModel.authenticate()
                    viewModel.getUser()
                }
            )
        }
    }
}


@Composable
@Preview
private fun AuthenticationScreenPreview() {
    AuthenticationScreen(navigationController = rememberNavController())
}