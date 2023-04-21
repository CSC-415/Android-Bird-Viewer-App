package com.example.csc415randyharrisapp.data.model

import com.example.csc415randyharrisapp.model.Bird

sealed class NuthatchSingleResponse {
    data class Success(val bird: Bird) : NuthatchSingleResponse()

    object Failure : NuthatchSingleResponse()
}