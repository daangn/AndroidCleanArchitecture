package com.daangn.www.photosample.feature.photodetail

import com.daangn.www.domain.repositories.PhotoRepository
import com.daangn.www.domain.usecases.GetPhotoUseCase
import dagger.Module
import dagger.Provides

@Module
class PhotoDetailModule {
    @Provides
    fun getPhotoDetailUseCase(photoRepository: PhotoRepository) = GetPhotoUseCase(photoRepository)

    @Provides
    fun providePhotoDetailViewModelFactory(getPhotoUseCase: GetPhotoUseCase) = PhotoDetailViewModelFactory(getPhotoUseCase)
}