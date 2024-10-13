package com.example.uikit.models

data class PostModel (
    val id: Int,
    val title: String,
    val body: String,
    val tags: List<String>,
    val reactions: ReactionsModel,
    val views: Int,
    val userId: Int
)