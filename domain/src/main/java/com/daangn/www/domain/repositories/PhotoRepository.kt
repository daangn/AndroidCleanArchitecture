package com.daangn.www.domain.repositories

import com.daangn.www.domain.entities.PhotoEntity
import io.reactivex.Single

interface PhotoRepository {
    fun getPhotos(limit: Int?, page: Int?): Single<List<PhotoEntity>>
    fun getPhoto(id: Long?): Single<PhotoEntity>
}