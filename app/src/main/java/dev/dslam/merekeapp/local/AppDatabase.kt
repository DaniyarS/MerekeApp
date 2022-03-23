package dev.dslam.merekeapp.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.dslam.merekeapp.models.Venue

@Database(entities = [Venue::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val merekeDao: MerekeDao
}