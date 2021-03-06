package dev.dslam.merekeapp.local

import dev.dslam.merekeapp.network.MerekeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository(private val merekeApi: MerekeApi, private val merekeDao: MerekeDao) {

    val newVenueList = merekeDao.getNewVenues()
    val newSingerList = merekeDao.getNewSingers()
    val allSingers = merekeDao.getAllSingers()
    val allShowmans = merekeDao.getAllShowmans()
    val allVenues = merekeDao.getAllVenues()
    val allDancersList = merekeDao.getAllDancers()
    val allMusiciansList = merekeDao.getAllMusicians()

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val newVenueList = merekeApi.getNewVenues()
            val newSingerList = merekeApi.getNewSingers()
        }
    }
}
