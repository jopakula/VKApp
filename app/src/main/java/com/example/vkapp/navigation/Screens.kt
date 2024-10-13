package com.example.vkapp.navigation

sealed class Screens (
    val screen: String
){
    data object Screen1: Screens("screen1")
    data object Screen2: Screens("screen2")
    data object Authentication: Screens("authentication")
    data object Main: Screens("main")
    data object Profile: Screens("profile")
    data object Detail: Screens("detail/{postId}"){
        fun createRoute(postId: Int) = "detail/$postId"
    }
}