package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Musicians(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val images: List<Image>,
    override val isActive: Boolean
) : Person(id, name, description, images, isActive), Parcelable
