package com.example.csc415randyharrisapp.model


import com.squareup.moshi.Json

data class Bird(
    @Json(name = "family")
    val family: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "images")
    val images: List<String>?,
    @Json(name = "lengthMax")
    val lengthMax: String?,
    @Json(name = "lengthMin")
    val lengthMin: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "order")
    val order: String,
    @Json(name = "recordings")
    val recordings: List<Any>,
    @Json(name = "sciName")
    val sciName: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "wingspanMax")
    val wingspanMax: String?,
    @Json(name = "wingspanMin")
    val wingspanMin: String?
)
