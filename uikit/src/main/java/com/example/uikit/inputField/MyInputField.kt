package com.example.uikit.inputField

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.common.Black
import com.example.uikit.common.Gray
import com.example.uikit.common.InputFieldBG
import com.example.uikit.text.MyText


/**
 * Компонент для отображения текстового поля
 *
 * @param isSingleLine Отвечает за перенос текста
 * @param maxLines Отвечает за максимальное количество отображаемых строк
 */

@Composable
fun MyInputField(
    modifier: Modifier = Modifier,
    text: String? = null,
    textSize: TextUnit = 19.sp,
    textColor: Color = Black,
    fontWeight: FontWeight = FontWeight.Normal,
    fontStyle: FontStyle = FontStyle.Normal,
    buttonHeight: Dp = 56.dp,
    backgroundColor: Color = InputFieldBG,
    showIconSearch: Boolean = true,
    showIconClear: Boolean = true,
    iconSearch: Painter = painterResource(id = R.drawable.ic_glass),
    iconClear: Painter = painterResource(id = R.drawable.ic_clear),
    iconSize: Dp = 22.dp,
    iconColor: Color = Gray,
    innerPadding: PaddingValues = PaddingValues(vertical = 6.dp, horizontal = 8.dp),
    roundingSize: Dp = 16.dp,
    onValueChange: (String) -> Unit = {},
    maxLines: Int = 1,
    isSingleLine: Boolean = true,
    hint: String? = null,
    textPadding: PaddingValues = PaddingValues(start = 8.dp, end = 8.dp),
    hintColor: Color = Gray,
) {
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = modifier
                .height(buttonHeight)
                .weight(1F)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                ) { focusRequester.requestFocus() }
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(roundingSize)
                )
                .padding(innerPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showIconSearch && text.isNullOrEmpty()) {
                Icon(
                    modifier = Modifier
                        .size(iconSize),
                    painter = iconSearch,
                    tint = iconColor,
                    contentDescription = null,
                )
            }
            Box(
                modifier = Modifier.weight(1F),
            ) {
                if (text.isNullOrEmpty() && !hint.isNullOrEmpty()) {
                    MyText(
                        modifier = Modifier
                            .padding(textPadding),
                        textSize = textSize,
                        textStyle = fontStyle,
                        textWeight = fontWeight,
                        text = hint,
                        textColor = hintColor
                    )
                }
                BasicTextField(
                    modifier = Modifier
                        .padding(textPadding)
                        .focusRequester(focusRequester),
                    value = text ?: "",
                    onValueChange = onValueChange,
                    maxLines = maxLines,
                    singleLine = isSingleLine,
                    textStyle = TextStyle(
                        color = textColor,
                        fontSize = textSize,
                        fontStyle = fontStyle,
                        fontWeight = fontWeight,
                    )
                )
            }
            if (showIconClear && !text.isNullOrEmpty()) {
                Icon(
                    modifier = Modifier
                        .size(iconSize)
                        .clickable { onValueChange("") },
                    painter = iconClear,
                    tint = iconColor,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
@Preview
private fun WBInputFieldPreview1() {
    MyInputField(
        iconSearch = painterResource(id = R.drawable.ic_glass),
        hint = "Hint",
    )
}


@Composable
@Preview
private fun WBInputFieldPreview2() {
    MyInputField(
        text = "Text",
        iconClear = painterResource(id = R.drawable.ic_clear)
    )
}
