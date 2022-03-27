package dev.dslam.merekeapp.models

data class Musicians(
    val id: Int,
    val name: String,
    val instruments: List<String>,
    val description: String,
    val rating: Float,
    val image: String
)
