package com.example.uikit.text

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.uikit.common.Black

/**
 * Компонент для отображения текста
 *
 * @param overflow Отвечает за то, что делать если текст не помещается в контент(TextOverflow.Clip - обрезан, TextOverflow.Ellipsis - многоточие)
 * @param textDecoration Отвечает за декорации которые будут рисоваться на тексте(подчеркивание или перечеркивание)
 * @param maxLines Отвечает за колличество строк
 */

@Composable
fun MyText(
    modifier: Modifier = Modifier,
    text: String = "Text",
    textColor: Color = Black,
    textSize: TextUnit = 16.sp,
    textWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    textStyle: FontStyle = FontStyle.Normal,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textDecoration: TextDecoration? = null,
    style: TextStyle = LocalTextStyle.current,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = textWeight,
        color = textColor,
        fontSize = textSize,
        textAlign = textAlign,
        fontStyle = textStyle,
        letterSpacing = letterSpacing,
        overflow = overflow,
        textDecoration = textDecoration,
        style = style,
        maxLines = maxLines
    )
}

@Composable
@Preview
private fun WBTextPreview(){
    MyText()
}
