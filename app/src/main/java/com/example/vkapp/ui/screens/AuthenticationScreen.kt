package com.example.vkapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uikit.button.MyButton
import com.example.uikit.inputField.MyInputField
import com.example.uikit.pictures.MyIcon
import com.example.uikit.text.MyText
import com.example.vkapp.ui.viewModels.AuthenticationScreenViewModel

@Composable
fun AuthenticationScreen(
    viewModel: AuthenticationScreenViewModel = viewModel()
) {

    val username by viewModel.username.observeAsState("")
    val email by viewModel.email.observeAsState("")
    val iconUrl by viewModel.iconUrl.observeAsState(null)
    val errorMessage by viewModel.errorMessage.observeAsState(null)
    val login by viewModel.login.observeAsState("")
    val password by viewModel.password.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        MyInputField(
            text = login,
            onValueChange = { viewModel.login.value = it }
        )
        MyInputField(
            text = password,
            onValueChange = { viewModel.password.value = it }
        )
        MyButton(
            buttonText = "Войти",
            onClick = {
                viewModel.authenticate(login, password)
            }
        )

        MyIcon(iconUrl = iconUrl)
        MyText(text = username)
        MyText(text = email)
        errorMessage?.let { error ->
            MyText(text = "Ошибка: $error", textColor = Color.Red)
        }
    }
}

@Composable
@Preview
private fun AuthenticationScreenPreview() {
    AuthenticationScreen()
}