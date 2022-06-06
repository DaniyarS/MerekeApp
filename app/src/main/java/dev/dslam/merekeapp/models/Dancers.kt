package dev.dslam.merekeapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dancers(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val images: List<Image>,
    override val isActive: Boolean,
    override val categoryId: String
) : Person(id, name, description, images, isActive, categoryId), Parcelable
