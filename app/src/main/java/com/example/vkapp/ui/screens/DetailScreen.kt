package com.example.vkapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.common.IconBG
import com.example.uikit.common.LightGray
import com.example.uikit.common.White
import com.example.uikit.pictures.MyIcon
import com.example.uikit.text.MyText
import com.example.vkapp.ui.viewModels.DetailScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
    postId: Int,
    onIconBackClick: () -> Unit = {},
){

    LaunchedEffect(Unit) {
        viewModel.getPostById(postId = postId)
    }

    val post by viewModel.post.observeAsState()

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(IconBG)
                .padding(start = 20.dp, top = 32.dp, end = 20.dp, bottom = 16.dp),
        ) {
            MyIcon(
                icon = painterResource(id = com.example.uikit.R.drawable.arrow_back),
                borderWidth = 0.dp,
                iconColorBG = White,
                onClick = onIconBackClick,
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            post?.let {
                MyText(
                    text = it.title,
                    textSize = 24.sp,
                    textWeight = FontWeight.Bold,
                    )
                MyText(
                    text = it.body,
                    textSize = 22.sp,
                    textWeight = FontWeight.SemiBold,
                )
                MyText(
                    text = it.reactions.toString(),
                    textSize = 22.sp,
                    textWeight = FontWeight.SemiBold,)
            }
        }
    }
}

@Composable
@Preview
private fun DetailScreenPreview(){
    DetailScreen(postId = 1)
}