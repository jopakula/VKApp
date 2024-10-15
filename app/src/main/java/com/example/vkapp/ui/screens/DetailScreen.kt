package com.example.vkapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.common.CardBG
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
    roundingSize: Dp = 16.dp,
    onIconBackClick: () -> Unit = {},
) {

    LaunchedEffect(postId) {
        viewModel.getPostById(postId = postId)
    }

    val post by viewModel.post.observeAsState()
    val isLiked by viewModel.isLiked.observeAsState(false)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = White),
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
                icon = painterResource(id = R.drawable.arrow_back),
                borderWidth = 0.dp,
                iconColorBG = LightGray,
                onClick = onIconBackClick,
            )
        }
        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(
                            color = CardBG,
                            shape = RoundedCornerShape(roundingSize),
                        )
                        .clip(RoundedCornerShape(roundingSize)),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                    ) {
                        post?.let { post ->
                            MyText(
                                text = post.title,
                                textSize = 38.sp,
                                textWeight = FontWeight.Bold,
                            )
                            MyText(
                                text = post.body,
                                textSize = 34.sp,
                                textWeight = FontWeight.SemiBold,
                            )
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                post.tags.forEach { tag ->
                                    Column(
                                        modifier = Modifier
                                            .background(
                                                Color.LightGray,
                                                shape = RoundedCornerShape(roundingSize)
                                            )
                                            .clip(RoundedCornerShape(roundingSize)),
                                    ) {
                                        MyText(
                                            modifier = Modifier
                                                .padding(horizontal = 10.dp, vertical = 4.dp),
                                            text = tag,
                                            textSize = 28.sp,
                                            textWeight = FontWeight.SemiBold,
                                        )
                                    }
                                }
                            }
                            Row(modifier = Modifier
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    MyText(
                                        text = post.reactions.likes.toString(),
                                        textSize = 28.sp
                                    )
                                    MyIcon(
                                        icon = painterResource(id = R.drawable.ic_heart),
                                        iconSize = 38.dp,
                                        onClick = {
                                            viewModel.toggleLike()
                                        },
                                        iconColor = if (isLiked) Color.Red else Color.Gray,
                                        indication = null
                                    )
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    MyIcon(
                                        icon = painterResource(id = R.drawable.ic_eye),
                                        iconSize = 38.dp,
                                        indication = null
                                    )
                                    MyText(
                                        text = post.views.toString(),
                                        textSize = 28.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}

@Composable
@Preview
private fun DetailScreenPreview() {
    DetailScreen(postId = 1)
}