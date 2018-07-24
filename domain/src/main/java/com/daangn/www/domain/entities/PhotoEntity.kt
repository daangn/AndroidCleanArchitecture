package com.daangn.www.domain.entities

data class PhotoEntity(val id: Long,
                       val albumId: Long,
                       val title: String,
                       val thumbnailUrl: String)