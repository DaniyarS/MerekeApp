package dev.dslam.merekeapp.local

import dev.dslam.merekeapp.models.TokenResponse
import dev.dslam.merekeapp.models.User
import dev.dslam.merekeapp.network.MerekeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class AppRepository(private val merekeApi: MerekeApi, private val merekeDao: MerekeDao) {

    val newVenueList = merekeDao.getNewVenues()
    val newSingerList = merekeDao.getNewSingers()
    val allSingers = merekeDao.getAllSingers()
    val allShowmans = merekeDao.getAllShowmans()
    //val allPersonList = merekeDao.getAllPerson()
    val allVenues = merekeDao.getAllVenues()
    val allDancersList = merekeDao.getAllDancers()
    val allMusiciansList = merekeDao.getAllMusicians()

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val personList = merekeApi.getAllPersons()
            val venueList = merekeApi.getAllRestaurants()

            //personList.body()?.let { merekeDao.addPersonList(personList = it) }
            //venueList.body()?.let { merekeDao.addVenues(venues = it) }
        }
    }

    suspend fun signIn(email: String, password: String): Response<TokenResponse> {
        val result = withContext(Dispatchers.IO) {
            merekeApi.userSign(User(email = email, password = password))
        }
        return result
    }

}
