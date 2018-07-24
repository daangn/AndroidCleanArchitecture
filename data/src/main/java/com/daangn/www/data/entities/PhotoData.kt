package com.daangn.www.data.entities

import com.google.gson.annotations.SerializedName

data class PhotoData(
    @SerializedName("id") val id: Long,
    @SerializedName("albumId") val albumId: Long,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String)