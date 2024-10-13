package com.example.vkapp.data.storage.models

data class DataPostModel(
    val id: Int,
    val title: String,
    val body: String,
    val tags: List<String>,
    val reactions: DataReactionsModel,
    val views: Int,
    val userId: Int
)