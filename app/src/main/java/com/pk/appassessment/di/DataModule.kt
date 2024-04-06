package com.pk.appassessment.di

import com.pk.appassessment.data.remote.RecentImagesApi
import com.pk.appassessment.data.repo.RecentImagesRepository
import com.pk.appassessment.domain.repo.RecentImagesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRecentImagesRepository(api: RecentImagesApi): RecentImagesRepo {
        return RecentImagesRepository(api)
    }
}