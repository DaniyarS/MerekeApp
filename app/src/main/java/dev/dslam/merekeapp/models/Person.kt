package dev.dslam.merekeapp.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import dev.dslam.merekeapp.models.typeConverters.ImageToString
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "persons")
open class Person(
    @PrimaryKey
    open val id: Int,
    @SerializedName("name")
    open val name: String,
    @SerializedName("description")
    open val description: String,
    @TypeConverters(ImageToString::class)
    @SerializedName("rating")
    open val rating: Float,
    @SerializedName("images")
    @TypeConverters(ImageToString::class)
    open val images: List<Image>
) : Parcelable {
    override fun toString(): String {
        return name + description
    }
}
