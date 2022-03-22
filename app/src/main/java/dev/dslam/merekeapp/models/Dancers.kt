package dev.dslam.merekeapp.models

data class Dancers(
    val id: Int,
    val name: String,
    val dances: List<String>,
    val description: String,
    val rating: Float,
    val image: String
)
