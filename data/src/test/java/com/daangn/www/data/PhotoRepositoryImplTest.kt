package com.daangn.www.data

import com.daangn.www.data.api.Api
import com.daangn.www.data.entities.PhotoData
import com.daangn.www.data.repository.PhotoRepositoryImpl
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class PhotoRepositoryImplTest {

    private lateinit var api: Api
    private lateinit var photoRepositoryImpl: PhotoRepositoryImpl

    @Before
    fun before() {
        api = mock(Api::class.java)
        photoRepositoryImpl = PhotoRepositoryImpl(api)
    }

    @Test
    fun testGetPhotoReturnsExpectedResult() {
        val photoData = PhotoData(1, 0, "photo", "")
        Mockito.`when`(api.getPhoto(1)).thenReturn(Single.just(photoData))

        photoRepositoryImpl.getPhoto(1).test()
            .assertComplete()
            .assertValue { it.title == "photo" }
    }

    @Test
    fun testGetPhotosReturnsExpectedResult() {
        val photos: List<PhotoData> = (0..4).map {
            PhotoData(it.toLong(), 0, "photo $it", "")
        }

        Mockito.`when`(api.getPhotos(limit = 4, page = 1)).thenReturn(Single.just(photos))

        photoRepositoryImpl.getPhotos(limit = 4, page = 1).test()
            .assertComplete()
            .assertValue { it.size == 5 }
    }
}