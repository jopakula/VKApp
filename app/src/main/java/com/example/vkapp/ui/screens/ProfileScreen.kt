package com.example.vkapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.common.White
import com.example.uikit.pictures.MyIcon
import com.example.uikit.text.MyText
import com.example.vkapp.ui.viewModels.ProfileScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileScreenViewModel = koinViewModel()
) {

    val user by viewModel.user.observeAsState()

    LaunchedEffect(Unit){
        viewModel.getUser()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {

        MyIcon(iconUrl = user?.image)
        MyText(text = user?.username?: "")
        MyText(text = user?.email?: "")
        MyText(text = user?.firstName?: "")
        MyText(text = user?.lastName?: "")
        MyText(text = user?.gender?: "")

    }

}

@Composable
@Preview
private fun ProfileScreenPreview(){
    ProfileScreen()
}