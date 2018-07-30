package com.daangn.www.data.repository

import com.daangn.www.data.api.Api
import com.daangn.www.domain.entities.PhotoEntity
import com.daangn.www.domain.repositories.PhotoRepository
import io.reactivex.Single

class PhotoRepositoryImpl(val api: Api): PhotoRepository {
    override fun getPhoto(id: Long?): Single<PhotoEntity> {
        return api.getPhoto(id).map { photoData ->
            PhotoEntity(id = photoData.id,
                albumId = photoData.albumId,
                title = photoData.title,
                thumbnailUrl = photoData.thumbnailUrl)
        }
    }

    override fun getPhotos(limit: Int?, page: Int?): Single<List<PhotoEntity>> {
        return api.getPhotos(limit, page).map { result ->
            result.map { photoData ->
                PhotoEntity(id = photoData.id,
                    albumId = photoData.albumId,
                    title = photoData.title,
                    thumbnailUrl = photoData.thumbnailUrl)
            }
        }
    }
}