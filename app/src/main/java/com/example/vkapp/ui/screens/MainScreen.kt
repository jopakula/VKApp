package com.example.vkapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.uikit.card.MyCard
import com.example.uikit.models.PostModel
import com.example.uikit.models.ReactionsModel
import com.example.uikit.pictures.MyIcon
import com.example.vkapp.navigation.Screens
import com.example.vkapp.ui.viewModels.MainScreenViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel(),
    navigationController: NavController,
) {

    val user by viewModel.user.observeAsState()
    val posts by viewModel.posts.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        delay(1000)
        viewModel.getUser()
    }



    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyIcon(
                iconUrl = user?.image,
                borderWidth = 0.dp,
                onClick = {
                    navigationController.navigate(Screens.Profile.screen)
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            items(posts) { post ->
                MyCard(post = post)
            }
        }

    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    MainScreen(navigationController = rememberNavController())
}