package com.example.csc415randyharrisapp.di

import com.example.csc415randyharrisapp.data.repository.BirdRepositoryImpl
import com.example.csc415randyharrisapp.data.repository.BirdRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindBirdRepository(
        birdRepositoryImpl: BirdRepositoryImpl
    ): BirdRepository
}