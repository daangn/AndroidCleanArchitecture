package com.daangn.www.photosample.entities

data class PhotoModel(val id: Long,
                      val albumId: Long,
                      val title: String,
                      val thumbnailUrl: String)