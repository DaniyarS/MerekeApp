package dev.dslam.merekeapp.network

import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.models.Venue
import retrofit2.http.GET

interface MerekeApi {
    @GET("new_venues")
    suspend fun getNewVenues(): List<Venue>

    @GET("new_singers")
    suspend fun getNewSingers(): List<Singer>
}