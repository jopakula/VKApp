package com.example.uikit.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.common.Black
import com.example.uikit.common.Blue
import com.example.uikit.common.ButtonEnterText
import com.example.uikit.common.Gray
import com.example.uikit.text.MyText

/**
 * Компонент для отображения кнопки
 *
 */

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    buttonHeight: Dp = 56.dp,
    buttonBGColor: Color = Blue,
    buttonText: String = ButtonEnterText,
    roundingSize: Dp = 16.dp,
    textSize: TextUnit = 20.sp,
    textColor: Color = Black,
    textWeight: FontWeight = FontWeight.Normal,
    borderWidth: Dp? = null,
    borderColor: Color = Gray,
    shadowElevation: Dp? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {

    val interactionSource = remember { MutableInteractionSource() }
    val borderModifier = if (borderWidth != null) {
        Modifier.border(
            width = borderWidth,
            color = borderColor,
            shape = RoundedCornerShape(roundingSize)
        )
    } else {
        Modifier
    }
    val shadowModifier = if (shadowElevation != null) {
        Modifier.shadow(
            elevation = shadowElevation,
            shape = RoundedCornerShape(roundingSize)
        )
    } else {
        Modifier
    }
    Row(
        modifier = modifier
            .then(shadowModifier)
            .fillMaxWidth()
            .height(buttonHeight)
            .clip(RoundedCornerShape(roundingSize))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                enabled = enabled,
                onClick = onClick,
            )
            .graphicsLayer {
                alpha = if (enabled) 1f else 0.5f
            }
            .background(
                color = buttonBGColor,
                shape = RoundedCornerShape(roundingSize)
            )
            .then(borderModifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        MyText(
            text = buttonText,
            textColor = textColor,
            textSize = textSize,
            textWeight = textWeight
        )
    }
}

@Composable
@Preview
private fun MyButtonPreview() {
    MyButton()
}