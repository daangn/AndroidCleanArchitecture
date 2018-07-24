package com.daangn.www.photosample.feature.photolist

import com.daangn.www.data.repository.PhotoRepositoryImpl
import com.daangn.www.domain.repositories.PhotoRepository
import com.daangn.www.domain.usecases.GetPhotosUseCase
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val photoListModule: Module = module {
    factory {
        PhotoRepositoryImpl(get()) as PhotoRepository
    }

    factory {
        GetPhotosUseCase(get())
    }

    factory {
        PhotoListViewModelFactory(get())
    }
}