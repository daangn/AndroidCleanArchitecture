package com.daangn.www.domain

import com.daangn.www.domain.entities.PhotoEntity
import com.daangn.www.domain.repositories.PhotoRepository
import com.daangn.www.domain.usecases.GetPhotoUseCase
import com.daangn.www.domain.usecases.GetPhotosUseCase
import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito

class UseCasesTest {

    @Test
    fun getPhotoDetail() {
        val photoEntity = PhotoEntity(1, 1, "title", "")
        val photoRepository = Mockito.mock(PhotoRepository::class.java)
        val usecase = GetPhotoUseCase(photoRepository)

        Mockito.`when`(photoRepository.getPhoto(1)).thenReturn(Single.just(photoEntity))
        usecase.execute(GetPhotoUseCase.Param(1))
            .test()
            .assertValue {
                it.title == "title"
            }
            .assertComplete()

    }

    @Test
    fun getPhotos() {
        val photoRepository = Mockito.mock(PhotoRepository::class.java)
        val useCase = GetPhotosUseCase(photoRepository)

        val movieEntities = (0..2).map { PhotoEntity(it.toLong(), 0L, "title:$it", "") }

        Mockito.`when`(photoRepository.getPhotos(limit = 3, page = 1)).thenReturn(Single.just(movieEntities))
        useCase.execute(GetPhotosUseCase.Param(limit = 3, page = 1))
            .test()
            .assertValue { it.size == 3 }
            .assertComplete()
    }
}