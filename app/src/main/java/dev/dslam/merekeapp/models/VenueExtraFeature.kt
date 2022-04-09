package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VenueExtraFeature(
    val smokingArea: String,
    val karaoke: String,
    val parkingArea: String
) : Parcelable
