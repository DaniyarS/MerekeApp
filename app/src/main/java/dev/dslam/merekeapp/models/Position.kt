package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Position(
    val position: Int
) : Parcelable