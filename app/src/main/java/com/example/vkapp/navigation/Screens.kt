package com.example.vkapp.navigation

sealed class Screens (
    val screen: String
){
    data object Splash: Screens("splash")
    data object Authentication: Screens("authentication")
    data object Main: Screens("main")
    data object Profile: Screens("profile")
    data object Detail: Screens("detail/{postId}"){
        fun createRoute(postId: Int) = "detail/$postId"
    }
}