package com.daangn.www.photosample.feature.photolist

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daangn.www.photosample.R
import com.daangn.www.photosample.common.BaseActivity
import com.daangn.www.photosample.databinding.ActivityPhotoListBinding
import org.koin.android.ext.android.inject

class PhotoListActivity : BaseActivity() {

//    @Inject
//    lateinit var photoListViewModelFactory: PhotoListViewModelFactory

    private val photoListViewModelFactory: PhotoListViewModelFactory by inject()

    private lateinit var viewModel: PhotoListViewModel

    private lateinit var photoListAdapter: PhotoListAdapter

    private lateinit var binding: ActivityPhotoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_list)
        viewModel = ViewModelProviders.of(this, photoListViewModelFactory).get(PhotoListViewModel::class.java)
        viewModel.getPhotos()

        photoListAdapter = PhotoListAdapter()
        binding.recyclerView.adapter = photoListAdapter

        viewModel.state.observe(this, Observer { viewState ->
            viewState?.let { photoListAdapter.photos = it.photos }
        })
    }
}
