package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Musicians(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val rating: Float,
    override val images: List<Image>
) : Person(id, name, description, rating, images), Parcelable