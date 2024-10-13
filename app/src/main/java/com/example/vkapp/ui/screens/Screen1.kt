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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.button.MyButton
import com.example.uikit.inputField.MyInputField
import com.example.uikit.pictures.MyIcon
import com.example.vkapp.navigation.Screens


@Composable
fun Screen1(
    navigationController: NavController,
) {

    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyIcon(
            iconUrl = "https://cdn-icons-png.flaticon.com/512/3048/3048122.png",
            iconSize = 300.dp,
            roundingSize = 6.dp,
            shadowElevation = 6.dp,
        )
        MyIcon(
            borderWidth = 0.dp
        )
        MyIcon(
            borderWidth = 4.dp
        )
        MyIcon(
            shadowElevation = 10.dp,
            borderWidth = 0.dp
        )
        MyIcon(
            shadowElevation = 14.dp,
        )
        MyInputField(
            text = text,
            onValueChange = { text = it}
        )
        MyButton(
            buttonText = "to screen 2",
            onClick = {
            navigationController.navigate(Screens.Screen2.screen)
        })
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
private fun Screen1Preview(){
    Screen1(navigationController = rememberNavController())
}