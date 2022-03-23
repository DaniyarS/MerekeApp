package dev.dslam.merekeapp.local

import dev.dslam.merekeapp.network.MerekeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository(private val merekeApi: MerekeApi, private val merekeDao: MerekeDao) {

    val newVenueList = merekeDao.getNewVenues()

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val newVenueList = merekeApi.getNewVenues()
        }
    }

}
