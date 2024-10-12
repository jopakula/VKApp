package com.example.uikit.pictures

import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    iconColor: Color? = null,
    contentScale: ContentScale = ContentScale.Crop,
    indication: Indication? = LocalIndication.current,
    onClick: () -> Unit = {},
) {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .size(iconSize)
            .clip(RoundedCornerShape(iconSize))
            .background(
                color = Color.Red,
                shape = RoundedCornerShape(iconSize)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = indication,
                onClick = onClick
            ),
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
