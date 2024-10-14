package com.example.uikit.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.common.CardBG
import com.example.uikit.models.PostModel
import com.example.uikit.models.ReactionsModel
import com.example.uikit.pictures.MyIcon
import com.example.uikit.text.MyText

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    roundingSize: Dp = 16.dp,
    post: PostModel,
    shadowElevation: Dp = 0.dp,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = shadowElevation,
                shape = RoundedCornerShape(roundingSize)
            )
            .clip(RoundedCornerShape(roundingSize))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                onClick = onClick,
            )
            .background(
                color = CardBG,
                shape = RoundedCornerShape(roundingSize)
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        MyText(
            text = post.title,
            textSize = 20.sp,
            textWeight = FontWeight.Bold
        )
        MyText(
            text = post.body,
            textSize = 18.sp,
            textWeight = FontWeight.SemiBold
        )
    }
}

@Composable
@Preview
private fun MyCardPreview() {
    val post = PostModel(
        id = 1,
        title = "title",
        body = "body",
        tags = listOf("tags1", "tags2"),
        reactions = ReactionsModel(1, 2),
        views = 1,
        userId = 1
    )
    MyCard(post = post)
}