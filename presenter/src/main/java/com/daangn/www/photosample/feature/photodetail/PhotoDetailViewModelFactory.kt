package com.daangn.www.photosample.feature.photodetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daangn.www.domain.usecases.GetPhotoUseCase

@Suppress("UNCHECKED_CAST")
class PhotoDetailViewModelFactory(private val getPhotoUseCase: GetPhotoUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotoDetailViewModel(getPhotoUseCase) as T
    }
}