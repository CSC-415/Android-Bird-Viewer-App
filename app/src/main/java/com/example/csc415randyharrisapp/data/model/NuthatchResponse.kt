package com.example.csc415randyharrisapp.data.model

import com.example.csc415randyharrisapp.model.Bird

sealed class NuthatchResponse {
    data class Success(val birds: List<Bird>) : NuthatchResponse()

    object Failure : NuthatchResponse()
}