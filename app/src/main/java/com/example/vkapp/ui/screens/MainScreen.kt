package com.example.vkapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.common.White
import com.example.uikit.pictures.MyIcon
import com.example.vkapp.ui.viewModels.MainScreenViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel()
){

    val user by viewModel.user.observeAsState()

    LaunchedEffect(Unit){
        delay(1000)
        viewModel.getUser()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {


        item {
            Row(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                MyIcon(
                    iconUrl = user?.image
                )
//                MyButton(
//                    buttonText = "Загрузить",
//                    onClick = {
//                        viewModel.getUser()
//                    }
//                )
            }
        }
    }
}

@Composable
@Preview
private fun MainScreenPreview(){
    MainScreen()
}