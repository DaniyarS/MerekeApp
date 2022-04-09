package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val imageUrl: String
) : Parcelable
