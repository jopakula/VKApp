package com.example.vkapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vkapp.ui.screens.AuthenticationScreen
import com.example.vkapp.ui.screens.DetailScreen
import com.example.vkapp.ui.screens.MainScreen
import com.example.vkapp.ui.screens.ProfileScreen
import com.example.vkapp.ui.screens.Screen1
import com.example.vkapp.ui.screens.Screen2

@Composable
fun Navigation(
    navigationController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navigationController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screens.Screen1.screen) { Screen1(navigationController = navigationController) }
        composable(Screens.Screen2.screen) { Screen2(navigationController = navigationController) }
        composable(Screens.Authentication.screen) { AuthenticationScreen(navigationController = navigationController) }
        composable(Screens.Main.screen) { MainScreen(navigationController = navigationController) }
        composable(Screens.Profile.screen) { ProfileScreen(onIconBackClick = { navigationController.popBackStack() }) }
        composable(Screens.Detail.screen) { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")?.toInt()
            if (postId != null) {
                DetailScreen(
                    postId = postId,
                    onIconBackClick = { navigationController.popBackStack() }
                )
            }
        }
    }
}