package com.example.kotlin.moviles.data.network.model

data class NinjaObject(
    val record_type: String,
    val value: String?,
    val mname: String? = null,
    val rname: String? = null,
    val serial: Long? = null,
    val refresh: Int? = null,
    val retry: Int? = null,
    val expire: Int? = null,
    val ttl: Int? = null,
    val flags: Int? = null,
    val tag: String? = null
) : NinjaBase()  // Extiende de NinjaBase para heredar status y message
