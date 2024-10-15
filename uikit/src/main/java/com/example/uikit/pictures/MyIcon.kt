package com.example.uikit.pictures

import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.uikit.R
import com.example.uikit.common.Gray

/**
 * Компонент для отображения иконки
 *
 * @param contentScale Отвечает за как изображение масштабируется и позиционируется в пределах границ своего контейнера
 * @param indication При помощи него можно отклбчить эфект кликабельности ( null)
 */


@Composable
fun MyIcon(
    modifier: Modifier = Modifier,
    icon: Painter = painterResource(id = R.drawable.avatar),
    iconUrl: String? = null,
    iconSize: Dp = 50.dp,
    roundingSize: Dp? = null,
    iconColor: Color? = null,
    iconColorBG: Color? = null,
    borderWidth: Dp? = null,
    borderColor: Color = Gray,
    contentScale: ContentScale = ContentScale.Crop,
    indication: Indication? = rememberRipple(),
    clickable: Boolean = true,
    onClick: () -> Unit = {},
) {
    val rounding = roundingSize ?: iconSize
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val borderModifier = if (borderWidth != null) {
        Modifier.border(
            width = borderWidth,
            color = borderColor,
            shape = RoundedCornerShape(rounding)
        )
    } else {
        Modifier
    }
    val clickModifier = if (clickable) {
        Modifier.clickable(
            interactionSource = interactionSource,
            indication = indication,
            onClick = onClick
        )
    } else {
        Modifier
    }
    Box(
        modifier = modifier
            .size(iconSize)
            .clip(RoundedCornerShape(rounding))
            .background(
                color = iconColorBG ?: Color.Transparent,
                shape = RoundedCornerShape(rounding)
            )
            .then(clickModifier)
            .then(borderModifier),
        contentAlignment = Alignment.Center
    ) {

        if (iconUrl != null) {
            AsyncImage(
                model = iconUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = contentScale,
                colorFilter = iconColor?.let { ColorFilter.tint(it) }
            )
        } else {
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = contentScale,
                colorFilter = iconColor?.let { ColorFilter.tint(it) }
            )
        }
    }
}

@Composable
@Preview
private fun MyIconPreview1() {
    MyIcon()
}

@Composable
@Preview
private fun MyIconPreview2() {
    MyIcon(
        icon = painterResource(id = R.drawable.ic_glass),
        iconColor = Color.White
    )
}

@Composable
@Preview
private fun MyIconPreview3() {
    MyIcon(
        icon = painterResource(id = R.drawable.ic_heart),
        iconColor = Color.White
    )
}


