package dev.dslam.merekeapp.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.dslam.merekeapp.models.typeConverters.ImageToString
import dev.dslam.merekeapp.models.typeConverters.VenueExtraFeatureToString
import dev.dslam.merekeapp.models.typeConverters.VenueInformationToString
import kotlinx.parcelize.Parcelize

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
    val images: List<Image>,
    @TypeConverters(VenueInformationToString::class)
    val information: VenueInformation,
    @TypeConverters(VenueExtraFeatureToString::class)
    val extraFeatures: VenueExtraFeature
) : Parcelable
