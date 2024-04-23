package com.example.kotlin.moviles.data.network

import com.example.kotlin.moviles.utilities.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NinjaApiClient {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val service: NinjaAPIService by lazy {
            retrofit.create(NinjaAPIService::class.java)
        }
    }
}
