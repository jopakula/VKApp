package com.example.vkapp.domain.models

data class DomainUserModel (
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
)