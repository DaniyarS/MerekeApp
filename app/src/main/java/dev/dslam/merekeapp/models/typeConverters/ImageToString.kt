package dev.dslam.merekeapp.models.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.dslam.merekeapp.models.Image

class ImageToString {

    private val gson = Gson()

    @TypeConverter
    fun imagesToString(images: List<Image>): String {
        return gson.toJson(images)
    }

    @TypeConverter
    fun stringToImages(data: String?): List<Image> {
        if (data == null) return listOf()

        val listType = object : TypeToken<List<Image>>() {}.type

        return gson.fromJson(data, listType)
    }
}
