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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.button.MyButton
import com.example.uikit.common.ButtonExitText
import com.example.uikit.common.Email
import com.example.uikit.common.Gender
import com.example.uikit.common.Gray
import com.example.uikit.common.IconBG
import com.example.uikit.common.LightGray
import com.example.uikit.common.Red
import com.example.uikit.common.Username
import com.example.uikit.common.White
import com.example.uikit.pictures.MyIcon
import com.example.uikit.text.MyText
import com.example.vkapp.navigation.Screens
import com.example.vkapp.ui.viewModels.ProfileScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileScreenViewModel = koinViewModel(),
    navigationController: NavController,
    onIconBackClick: () -> Unit = {},
) {

    val user by viewModel.user.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.getUser()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        verticalArrangement = Arrangement.spacedBy(34.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
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
                iconColorBG = LightGray,
                onClick = onIconBackClick,
            )
        }
        MyIcon(
            iconUrl = user?.image,
            iconSize = 360.dp,
            contentScale = ContentScale.FillBounds,
            borderWidth = 1.dp,
            clickable = false,
        )
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MyText(
                text = user?.firstName ?: "",
                textSize = 44.sp,
                textWeight = FontWeight.Bold,
            )
            MyText(
                text = user?.lastName ?: "",
                textSize = 44.sp,
                textWeight = FontWeight.Bold,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            MyText(
                text = "$Username:\n@${user?.username?: ""}",
                textSize = 22.sp,
                textWeight = FontWeight.Medium,
                textColor = Gray,
            )
            MyText(
                text = "$Gender:\n${user?.gender ?: ""}",
                textSize = 22.sp,
                textWeight = FontWeight.Medium,
                textColor = Gray,
            )
            MyText(
                text = "$Email:\n${user?.email ?: ""}",
                textSize = 22.sp,
                textWeight = FontWeight.Medium,
                textColor = Gray,
            )
        }
        MyButton(
            modifier = Modifier
                .padding(16.dp),
            buttonText = ButtonExitText,
            buttonBGColor = White,
            textSize = 22.sp,
            textWeight = FontWeight.SemiBold,
            textColor = Red,
            borderWidth = 0.dp,
            shadowElevation = 6.dp,
            onClick = {
                navigationController.navigate(Screens.Authentication.screen)
            }
        )
    }
}

@Composable
@Preview
private fun ProfileScreenPreview() {
    ProfileScreen(navigationController = rememberNavController())
}