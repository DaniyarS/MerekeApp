package dev.dslam.merekeapp.models

data class User(
    val id: Int? = null,
    val name: String? = null,
    val phoneNumber: String? = null,
    val email: String,
    val password: String
)
