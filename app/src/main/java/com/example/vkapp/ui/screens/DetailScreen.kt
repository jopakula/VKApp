package com.example.vkapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.pictures.MyIcon
import com.example.uikit.text.MyText

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    postId: Int? = null,
    onIconBackClick: () -> Unit = {},
){

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
        ) {
            MyIcon(
                icon = painterResource(id = com.example.uikit.R.drawable.arrow_back),
                borderWidth = 0.dp,
                onClick = onIconBackClick,
            )
        }
    }
}

@Composable
@Preview
private fun DetailScreenPreview(){
    DetailScreen()
}