package dev.dslam.merekeapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venues")
data class Venue(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val rating: Float,
    val address: String,
    val image: String
)
