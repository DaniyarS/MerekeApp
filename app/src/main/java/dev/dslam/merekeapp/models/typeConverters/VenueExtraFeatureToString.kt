package dev.dslam.merekeapp.models.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.dslam.merekeapp.models.VenueExtraFeature

class VenueExtraFeatureToString {

    private val gson = Gson()

    @TypeConverter
    fun venueExtraFeatureToString(venueExtraFeature: VenueExtraFeature): String {
        return gson.toJson(venueExtraFeature)
    }

    @TypeConverter
    fun stringToVenueExtraFeature(data: String?): VenueExtraFeature {
        if (data == null) return VenueExtraFeature(
            karaoke = "Есть",
            smokingArea = "Есть",
            parkingArea = "Неохраняемая, бесплатная"
        )

        val listType = object : TypeToken<VenueExtraFeature>() {}.type

        return gson.fromJson(data, listType)
    }
}
