package com.daangn.www.domain.usecases

import com.daangn.www.domain.entities.PhotoEntity
import com.daangn.www.domain.repositories.PhotoRepository
import io.reactivex.Single

class GetPhotosUseCase(private val photoRepository: PhotoRepository): SingleUseCase<GetPhotosUseCase.Param, List<PhotoEntity>> {
    override fun execute(params: Param?): Single<List<PhotoEntity>> {
        return photoRepository.getPhotos(params?.limit, params?.page)
    }

    data class Param(val limit: Int, val page: Int)
}