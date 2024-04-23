package com.example.kotlin.moviles.data.network

object NetworkModuleDI {
    val ninjaApiService by lazy { NinjaApiClient.service }
}
