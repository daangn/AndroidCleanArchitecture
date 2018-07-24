package com.daangn.www.photosample.feature.photolist

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daangn.www.photosample.R
import com.daangn.www.photosample.common.BaseActivity
import org.koin.android.ext.android.inject

class PhotoListActivity : BaseActivity() {

    val photoListViewModelFactory: PhotoListViewModelFactory by inject()

    private lateinit var viewModel: PhotoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        viewModel = ViewModelProviders.of(this, photoListViewModelFactory).get(PhotoListViewModel::class.java)
        viewModel.getPhotos()
        viewModel.state.observe(this, Observer { viewState ->
            Toast.makeText(this, "총 ${viewState?.photos?.size} 장 받아옴", Toast.LENGTH_LONG).show()
        })
    }
}
