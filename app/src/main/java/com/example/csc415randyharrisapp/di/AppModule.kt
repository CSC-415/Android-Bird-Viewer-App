package com.example.csc415randyharrisapp.di

import com.example.csc415randyharrisapp.data.BirdAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBirdAPI(): BirdAPI =
        Retrofit.Builder()
            .baseUrl("https://nuthatch.lastelm.software")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
}