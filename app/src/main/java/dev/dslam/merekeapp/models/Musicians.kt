package dev.dslam.merekeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Musicians(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val images: List<Image>,
    override val isActive: Boolean,
    override val categoryId: String
) : Person(id, name, description, images, isActive, categoryId), Parcelable
