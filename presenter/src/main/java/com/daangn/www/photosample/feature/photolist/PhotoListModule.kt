package com.daangn.www.photosample.feature.photolist

import com.daangn.www.domain.repositories.PhotoRepository
import com.daangn.www.domain.usecases.GetPhotosUseCase
import dagger.Module
import dagger.Provides

@Module
class PhotoListModule {
    @Provides
    fun provideGetPhotosUseCase(photoRepository: PhotoRepository): GetPhotosUseCase {
        return GetPhotosUseCase(photoRepository)
    }

    @Provides
    fun providePhotoListViewModelFactory(getPhotosUseCase: GetPhotosUseCase): PhotoListViewModelFactory {
        return PhotoListViewModelFactory(getPhotosUseCase)
    }
}