package dev.dslam.merekeapp.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity(tableName = "showmans")
@Parcelize
data class Showman(
    override val id: Int,
    override val name: String,
    override val description: String,
    override val rating: Float,
    override val images: List<Image>
) : Person(id, name, description, rating, images), Parcelable
