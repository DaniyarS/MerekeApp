package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Singer(
    val id: Int,
    val name: String,
    val description: String,
    val rating: Float,
    val image: String
) : Parcelable
