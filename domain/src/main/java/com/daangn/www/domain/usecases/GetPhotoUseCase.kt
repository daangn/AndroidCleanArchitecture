package com.daangn.www.domain.usecases

import com.daangn.www.domain.entities.PhotoEntity
import com.daangn.www.domain.repositories.PhotoRepository
import io.reactivex.Single

class GetPhotoUseCase(private val photoRepository: PhotoRepository): SingleUseCase<GetPhotoUseCase.Param, PhotoEntity> {
    override fun execute(params: Param?): Single<PhotoEntity> {
        return photoRepository.getPhoto(params?.id)
    }

    data class Param(val id: Long)
}