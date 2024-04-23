package com.example.kotlin.moviles.data.network.model

data class DnsLookupResponse(
    val records: List<NinjaObject>
) : NinjaBase()
