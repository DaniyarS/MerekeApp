package dev.dslam.merekeapp.network

import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.models.TokenResponse
import dev.dslam.merekeapp.models.User
import dev.dslam.merekeapp.models.Venue
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MerekeApi {
    @GET("new_venues")
    suspend fun getNewVenues(): List<Venue>

    @GET("new_singers")
    suspend fun getNewSingers(): List<Singer>

    @POST("auth/users")
    suspend fun userAuth(
        @Body
        userCred: User
    ) : Response<Any>

    @POST("/auth/jwt/create")
    suspend fun userSign(
        @Body
        userCred: User
    ) : Response<TokenResponse>
}
