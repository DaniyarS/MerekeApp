package dev.dslam.merekeapp.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.dslam.merekeapp.models.typeConverters.ImageToString
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "persons")
open class Person(
    @PrimaryKey
    open val id: Int,
    open val name: String,
    open val description: String,
    @TypeConverters(ImageToString::class)
    open val images: List<Image>,
    open val isActive: Boolean
) : Parcelable
