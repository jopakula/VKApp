package com.example.vkapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.button.MyButton
import com.example.uikit.inputField.MyInputField
import com.example.uikit.pictures.MyIcon
import com.example.uikit.text.MyText
import com.example.vkapp.ui.viewModels.AuthenticationScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AuthenticationScreen(
    viewModel: AuthenticationScreenViewModel = viewModel()
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        MyInputField(
            text = login,
            onValueChange = { login = it }
        )
        MyInputField(
            text = password,
            onValueChange = { password = it }
        )
        MyButton(
            buttonText = "Войти",
            onClick = {
                viewModel.authenticate(login, password)
            }
        )

        MyIcon(iconUrl = viewModel.iconUrl)
        MyText(text = viewModel.username)
        MyText(text = viewModel.email)
        viewModel.errorMessage?.let { error ->
            MyText(text = "Ошибка: $error", textColor = Color.Red)
        }
    }
}

@Composable
@Preview
private fun AuthenticationScreenPreview() {
    AuthenticationScreen()
}