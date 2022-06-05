package dev.dslam.merekeapp.local

import dev.dslam.merekeapp.network.MerekeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository(private val merekeApi: MerekeApi, private val merekeDao: MerekeDao) {

    val allPersonList = merekeDao.getAllPerson()
    val allVenues = merekeDao.getAllVenues()
    val allDancer

    suspend fun refreshMainPage() {
        withContext(Dispatchers.IO) {
            val personList =  merekeApi.getAllPersons()
            personList.body()?.let { merekeDao.addPersonList(personList = it) }

            val venueList = merekeApi.getAllRestaurants()
            venueList.body()?.let { merekeDao.addVenues(venues = it) }
        }
    }
}
