package com.example.csc415randyharrisapp.data.model

import com.example.csc415randyharrisapp.model.Bird

sealed class BirdResponse {
    data class Success(val birds: List<Bird>) : BirdResponse()

    object Failure : BirdResponse()
}