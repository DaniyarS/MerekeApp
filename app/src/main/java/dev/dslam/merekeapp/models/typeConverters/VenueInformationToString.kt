package dev.dslam.merekeapp.models.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.dslam.merekeapp.models.Image
import dev.dslam.merekeapp.models.VenueInformation

class VenueInformationToString {

    private val gson = Gson()

    @TypeConverter
    fun venueInformationToString(venueInformation: VenueInformation): String {
        return gson.toJson(venueInformation)
    }

    @TypeConverter
    fun stringToVenueInformationToString(data: String?): VenueInformation {
        if (data == null) return VenueInformation()

        val listType = object : TypeToken<VenueInformation>() {}.type

        return gson.fromJson(data, listType)
    }
}