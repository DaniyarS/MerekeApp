package dev.dslam.merekeapp.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.dslam.merekeapp.models.Venue
import dev.dslam.merekeapp.models.typeConverters.ImageToString
import dev.dslam.merekeapp.models.typeConverters.VenueExtraFeatureToString
import dev.dslam.merekeapp.models.typeConverters.VenueInformationToString

@Database(entities = [Venue::class], version = 1, exportSchema = false)
@TypeConverters(ImageToString::class, VenueExtraFeatureToString::class, VenueInformationToString::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val merekeDao: MerekeDao
}
