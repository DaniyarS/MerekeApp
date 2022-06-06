package dev.dslam.merekeapp.local

import android.util.Log
import dev.dslam.merekeapp.network.MerekeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository(private val merekeApi: MerekeApi, private val merekeDao: MerekeDao) {

    val allPersonList = merekeDao.getAllPerson()
    val allVenues = merekeDao.getAllVenues()
    val allSingers = merekeDao.getPersonByCategory("1")
    val allDancer = merekeDao.getPersonByCategory("2")
    val allMusicians = merekeDao.getPersonByCategory("4")
    val allShowmans = merekeDao.getPersonByCategory("5")

    suspend fun refreshMainPage() {
        withContext(Dispatchers.IO) {
            val personList =  merekeApi.getAllPersons()
            personList.body()?.let { merekeDao.addPersonList(personList = it) }

            Log.d("DANIK", "DANIK" + personList.body().toString())

            val venueList = merekeApi.getAllRestaurants()
            venueList.body()?.let { merekeDao.addVenues(venues = it) }

            Log.d("DANIK", "DANIK" + venueList.body().toString())
        }
    }
}
