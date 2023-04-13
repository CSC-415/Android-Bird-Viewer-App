package com.example.csc415randyharrisapp.data

import com.example.csc415randyharrisapp.model.BirdResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface BirdAPI {
    //Use Query param for API key, can also use header for API key
    @GET("/birds")
    @Headers("API-Key: fa76af19-5e2e-42e2-9ea6-7f4457453d7d")
    suspend fun getBirds(): Response<BirdResponse>
}