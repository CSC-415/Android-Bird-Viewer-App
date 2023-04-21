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
    val recordings: List<Recording>,
    @Json(name = "sciName")
    val sciName: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "wingspanMax")
    val wingspanMax: String?,
    @Json(name = "wingspanMin")
    val wingspanMin: String?
) {
    data class Recording(
        @Json(name = "id")
        val id: Int,
        @Json(name = "birdId")
        val birdId: Int,
        @Json(name = "sp")
        val sp: String,
        @Json(name = "ssp")
        val ssp: String,
        @Json(name = "en")
        val en: String,
        @Json(name = "file")
        val file: String,
        @Json(name = "length")
        val length: String,
        @Json(name = "rec")
        val rec: String,
        @Json(name = "bird-seen")
        val birdSeen: String,
        @Json(name = "rmk")
        val rmk: String,
        )

    companion object{
        fun createEmptyBird() = Bird(
            family = "",
            id = 0,
            images = emptyList(),
            lengthMax = "",
            lengthMin = "",
            name = "",
            order = "",
            recordings = emptyList(),
            sciName = "",
            status = "",
            wingspanMax = "",
            wingspanMin = ""
        )
    }
}
