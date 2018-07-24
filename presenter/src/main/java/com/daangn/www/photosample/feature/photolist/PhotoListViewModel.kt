package com.daangn.www.photosample.feature.photolist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.daangn.www.domain.usecases.GetPhotosUseCase
import com.daangn.www.photosample.common.BaseViewModel
import com.daangn.www.photosample.entities.PhotoModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotoListViewModel(private val getPhotosUseCase: GetPhotosUseCase): BaseViewModel() {

    var state: MutableLiveData<PhotoListViewState> = MutableLiveData()

    fun getPhotos() {
        addDisposable(getPhotosUseCase.execute(GetPhotosUseCase.Param(limit = 3, page = 1))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { entities -> Single.fromCallable {
                entities.map {
                    PhotoModel(it.id, it.albumId, it.title, it.thumbnailUrl)
                }}
            }
            .subscribe ({ photos ->
                state.value = PhotoListViewState(false, photos = photos)
            },{
                Log.e("xxxxxxx", "xxxxxx   : " + it.message)
            }))
    }
}