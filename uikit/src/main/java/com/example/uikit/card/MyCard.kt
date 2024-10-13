package com.example.uikit.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.common.ButtonUnEnableBG
import com.example.uikit.text.MyText

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    roundingSize: Dp = 16.dp,
    onClick: () -> Unit = {},
){
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(roundingSize))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                onClick = onClick,
            )
            .background(
                color = ButtonUnEnableBG,
                shape = RoundedCornerShape(roundingSize)
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)

    ) {
        MyText()
        MyText()
        MyText()
    }
}

@Composable
@Preview
private fun MyCardPreview(){
    MyCard()
}