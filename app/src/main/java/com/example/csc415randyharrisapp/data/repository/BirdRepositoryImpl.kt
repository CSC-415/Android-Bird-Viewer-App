package com.example.csc415randyharrisapp.data.repository

import com.example.csc415randyharrisapp.data.BirdAPI
import com.example.csc415randyharrisapp.data.model.BirdResponse
import javax.inject.Inject

class BirdRepositoryImpl @Inject constructor(
    private val birdAPI: BirdAPI,
) : BirdRepository {

    override suspend fun getBirds(): BirdResponse {
        val result = birdAPI.getBirds()
        return if (result.isSuccessful) {
            BirdResponse.Success(result.body()?.birds ?: emptyList())
        } else {
            BirdResponse.Failure
        }
    }
}