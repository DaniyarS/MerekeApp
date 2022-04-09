package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class Person(
    open val id: Int,
    open val name: String,
    open val description: String,
    open val rating: Float,
    open val images: List<Image>
) : Parcelable
