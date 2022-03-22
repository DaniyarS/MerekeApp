package dev.dslam.merekeapp.models

data class Venue(
    val id: Int,
    val name: String,
    val description: String,
    val rating: Float,
    val address: String,
    val image: String
)
