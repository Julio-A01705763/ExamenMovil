package com.example.kotlin.moviles.data.network

import com.example.kotlin.moviles.data.network.model.NinjaObject
import com.example.kotlin.moviles.utilities.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NinjaAPIService {
    @Headers("X-Api-Key: ${Constants.API_KEY}")
    @GET("dnslookup")
    suspend fun getDnsLookup(@Query("domain") domain: String): Response<List<NinjaObject>>
}
