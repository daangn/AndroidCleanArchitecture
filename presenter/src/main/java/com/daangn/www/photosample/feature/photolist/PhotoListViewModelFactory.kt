package com.daangn.www.photosample.feature.photolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daangn.www.domain.usecases.GetPhotosUseCase

@Suppress("UNCHECKED_CAST")
class PhotoListViewModelFactory(private val getPhotosUseCase: GetPhotosUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotoListViewModel(getPhotosUseCase) as T
    }
}