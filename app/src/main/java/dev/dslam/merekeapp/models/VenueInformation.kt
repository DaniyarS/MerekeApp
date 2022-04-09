package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VenueInformation(
    val kitchen: String? = null,
    val averageCheck: String? = null,
    val quantityPlace: Int? = null,
    val workingTime: String? = null
) : Parcelable
