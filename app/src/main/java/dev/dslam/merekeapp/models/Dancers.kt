package dev.dslam.merekeapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dancers(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val rating: Float,
    override val images: List<Image>
) : Person(id, name, description, rating, images), Parcelable
