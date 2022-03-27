package dev.dslam.merekeapp.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.dslam.merekeapp.models.typeConverters.ImageToString
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "venues")
@Parcelize
data class Venue(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val rating: Float,
    val address: String,
    @TypeConverters(ImageToString::class)
    val images: List<Image>
): Parcelable
