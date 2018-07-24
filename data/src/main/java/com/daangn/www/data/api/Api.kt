package com.daangn.www.data.api

import com.daangn.www.data.entities.PhotoData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("photos")
    fun getPhotos(@Query("_limit") limit: Int?,
                  @Query("_page") page: Int? = 1): Single<List<PhotoData>>
}