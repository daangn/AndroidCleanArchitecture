package com.daangn.www.photosample.feature.photodetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.daangn.www.domain.entities.PhotoEntity
import com.daangn.www.domain.usecases.GetPhotoUseCase
import com.daangn.www.photosample.common.BaseViewModel
import com.daangn.www.photosample.entities.PhotoModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotoDetailViewModel(val getPhotoUseCase: GetPhotoUseCase): BaseViewModel() {

    val state: MutableLiveData<PhotoDetailViewState> = MutableLiveData()

    fun getPhotoDetail() {
        addDisposable(getPhotoUseCase.execute(GetPhotoUseCase.Param(1L))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { photoEntity ->
                PhotoModel(photoEntity.id,
                    photoEntity.albumId,
                    photoEntity.title,
                    photoEntity.thumbnailUrl)
            }
            .subscribe ({
                val viewState = PhotoDetailViewState(isLoading = false,
                    title = it.title,
                    thumbnailUrl = it.thumbnailUrl)
                state.value = viewState
            }, {
                Log.e("PhotoListViewModel", it.message)
            }))
    }
}