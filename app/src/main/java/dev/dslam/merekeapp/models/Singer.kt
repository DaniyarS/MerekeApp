package dev.dslam.merekeapp.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity(tableName = "singers")
@Parcelize
data class Singer(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val images: List<Image>,
    override val isActive: Boolean
) : Person(id, name, description, images, isActive), Parcelable
