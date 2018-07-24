package com.daangn.www.photosample.feature.photolist

import com.daangn.www.photosample.entities.PhotoModel

data class PhotoListViewState(var isLoading: Boolean = false,
                              var photos: List<PhotoModel>)