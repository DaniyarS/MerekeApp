package dev.dslam.merekeapp.models

data class User(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val password: String
)
