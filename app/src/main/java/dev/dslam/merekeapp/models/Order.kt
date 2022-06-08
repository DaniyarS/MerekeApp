package dev.dslam.merekeapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val date: String,
    val time: String,
    val phoneNumber: String = "87079797167"
)
