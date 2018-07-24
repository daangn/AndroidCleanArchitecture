package com.daangn.www.photosample.di

import com.daangn.www.data.api.Api
import com.daangn.www.data.repository.PhotoRepositoryImpl
import com.daangn.www.domain.repositories.PhotoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    fun providePhotoRepository(api: Api): PhotoRepository {
        return PhotoRepositoryImpl(api)
    }
}