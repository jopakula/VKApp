package com.example.vkapp.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.uikit.common.Blue
import com.example.uikit.text.MyText
import com.example.vkapp.R
import com.example.vkapp.navigation.Screens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navigationController: NavController,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.friends))
    val alpha = remember {
        Animatable(0F)
    }
    LaunchedEffect(key1 = true) {
        alpha.animateTo(
            1f,
            animationSpec = tween(3000)
        )
        delay(3000)
        navigationController.popBackStack()
        navigationController.navigate(Screens.Authentication.screen)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        item {
            LottieAnimation(
                modifier = Modifier.size(300.dp),
                composition = composition,
                iterations = LottieConstants.IterateForever,
            )
        }
        item {
            MyText(
                modifier = Modifier
                    .alpha(alpha.value)
                    .padding(top = 20.dp),
                text = "VK app",
                textSize = 40.sp,
                textWeight = FontWeight.SemiBold,
                textColor = Blue
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)

private fun SplashScreenPreview() {
    SplashScreen(
        navigationController = rememberNavController(),
    )
}