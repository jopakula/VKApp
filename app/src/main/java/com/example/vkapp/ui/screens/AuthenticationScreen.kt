package com.example.vkapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uikit.button.MyButton
import com.example.uikit.common.ButtonEnterLoadingText
import com.example.uikit.common.ButtonEnterText
import com.example.uikit.common.InputFieldLoginText
import com.example.uikit.common.InputFieldPasswordText
import com.example.uikit.common.White
import com.example.uikit.inputField.MyInputField
import com.example.uikit.pictures.MyIcon
import com.example.uikit.text.MyText
import com.example.vkapp.network.models.UserModelPresentation
import com.example.vkapp.ui.viewModels.AuthenticationScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthenticationScreen(
    viewModel: AuthenticationScreenViewModel = koinViewModel()
) {

    val username by viewModel.user.observeAsState(UserModelPresentation(id = 0, username = "", email = "", firstName = "", lastName = "", gender = "", image = ""))
    val email = username.email
    val iconUrl = username.image
    val errorMessage by viewModel.errorMessage.observeAsState(null)
    val login by viewModel.login.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val loading by viewModel.loading.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MyInputField(
                text = login,
                onValueChange = { viewModel.login.value = it },
                showIconSearch = false,
                hint = InputFieldLoginText
            )
            MyInputField(
                text = password,
                onValueChange = { viewModel.password.value = it },
                showIconSearch = false,
                hint = InputFieldPasswordText
            )
            MyButton(
                buttonText = if (loading) ButtonEnterLoadingText else ButtonEnterText,
                onClick = {
                    viewModel.authenticate()
                }
            )
        }

        MyIcon(iconUrl = iconUrl)
        MyText(text = username.username)
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