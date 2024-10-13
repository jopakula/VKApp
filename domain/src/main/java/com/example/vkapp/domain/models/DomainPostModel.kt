package com.example.vkapp.domain.models

data class DomainPostModel(
    val id: Int,
    val title: String,
    val body: String,
    val tags: List<String>,
    val reactions: DomainReactionsModel,
    val views: Int,
    val userId: Int
)