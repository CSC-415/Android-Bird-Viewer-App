package com.example.csc415randyharrisapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class BirdResponse(
    val birds: List<Bird>,
)
