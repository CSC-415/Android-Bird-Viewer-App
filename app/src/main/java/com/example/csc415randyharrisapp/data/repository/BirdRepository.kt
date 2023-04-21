package com.example.csc415randyharrisapp.data.repository

import com.example.csc415randyharrisapp.data.model.NuthatchResponse
import com.example.csc415randyharrisapp.data.model.NuthatchSingleResponse

interface BirdRepository {
    // Although it seems slightly convoluted, this is standard practice to make
    // for easier understandability and testing.
    suspend fun getBirds(): NuthatchResponse

    suspend fun getBird(id: Int): NuthatchSingleResponse
}