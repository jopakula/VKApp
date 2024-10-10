package com.example.vkapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.button.MyButton
import com.example.vkapp.navigation.Screens

@Composable
fun Screen2(
    navigationController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyButton(
            buttonText = "to screen 1",
            onClick = {
            navigationController.navigate(Screens.Screen1.screen)
        })
    }
}
@Composable
@Preview
private fun Screen2Preview(){
    Screen2(navigationController = rememberNavController())
}