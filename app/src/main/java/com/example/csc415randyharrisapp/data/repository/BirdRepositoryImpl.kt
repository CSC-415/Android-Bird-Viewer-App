package com.example.csc415randyharrisapp.data.repository

import android.util.Log
import com.example.csc415randyharrisapp.data.BirdAPI
import com.example.csc415randyharrisapp.data.model.NuthatchResponse
import com.example.csc415randyharrisapp.data.model.NuthatchSingleResponse
import com.example.csc415randyharrisapp.model.Bird
import com.example.csc415randyharrisapp.model.BirdResponse
import javax.inject.Inject

class BirdRepositoryImpl @Inject constructor(
    private val birdAPI: BirdAPI,
) : BirdRepository {

    override suspend fun getBirds(): NuthatchResponse {
        val result = birdAPI.getBirds()
        val birdList = mutableListOf<Bird>()

        return if (result.isSuccessful) {
            Log.d("Getting Birds", "...")
            // This only goes to 50 for now but can go all the way up to 634
            for (i in 0..49){
                val currBird: Bird? = result.body()?.get(i)


                if (currBird != null) {
                    birdList.add(currBird)
                }
            }
            NuthatchResponse.Success(birdList)
        }
        else {
            Log.d("this is getbirds", "failure!")
            NuthatchResponse.Failure
        }
    }

    override suspend fun getBird(id: Int): NuthatchSingleResponse {
        val result = birdAPI.getBird(id)
        return if (result.isSuccessful) {
            NuthatchSingleResponse.Success(result.body() ?: Bird.createEmptyBird())
        } else {
            NuthatchSingleResponse.Failure
        }
    }
}