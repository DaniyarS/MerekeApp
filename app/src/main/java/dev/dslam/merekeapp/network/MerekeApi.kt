package dev.dslam.merekeapp.network

import dev.dslam.merekeapp.models.*
import retrofit2.Response
import retrofit2.http.*

interface MerekeApi {
//    @GET("shop/products/")
//    suspend fun getVenues(
//        @Query("catogery_id")
//        catId: String? = "3"
//    ): Response<List<Venue>>

    @GET("shop/products/")
    suspend fun getPersonByCategory(
        @Query("catogery_id")
        catId: String
    ): Response<List<Person>>

    @GET("shop/products/")
    suspend fun getAllPersons(): Response<List<Person>>

    @GET("shop/products/")
    suspend fun getAllRestaurants(
        @Query("catogery_id")
        catId: String = "3"
    ): Response<List<Venue>>

//    @GET("shop/products/")
//    suspend fun getShowmans(
//        @Query("catogery_id")
//        catId: String? = "5"
//    ): Response<List<Showman>>
//
//    @GET("shop/products/")
//    suspend fun getMusicians(
//        @Query("catogery_id")
//        catId: String? = "4"
//    ): Response<List<Musicians>>
//
//    @GET("shop/products/")
//    suspend fun getDancers(
//        @Query("catogery_id")
//        catId: String? = "1"
//    ): Response<List<Dancers>>

    @POST("auth/users")
    suspend fun userAuth(
        @Body
        userCred: User
    ): Response<Any>

    @POST("/auth/jwt/create")
    suspend fun userSign(
        @Body
        userCred: User
    ): Response<TokenResponse>
}
