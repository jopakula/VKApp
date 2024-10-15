package com.example.vkapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.example.uikit.card.MyCard
import com.example.uikit.common.IconBG
import com.example.uikit.common.LightGray
import com.example.uikit.common.TopBarBg
import com.example.uikit.common.White
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
            .background(color = White),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(TopBarBg)
                .padding(start = 20.dp, top = 32.dp, end = 20.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyIcon(
                iconUrl = user?.image,
                borderWidth = 0.dp,
                iconColorBG = IconBG,
                onClick = {
                    navigationController.navigate(Screens.Profile.screen)
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(posts) { post ->
                MyCard(
                    post = post,
                    shadowElevation = 6.dp,
                    onClick = {
                        navigationController.navigate(Screens.Detail.createRoute(postId = post.id))
                    }
                )
            }
        }
    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    MainScreen(navigationController = rememberNavController())
}