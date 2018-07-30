package com.daangn.www.photosample.feature.photodetail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.daangn.www.photosample.R
import com.daangn.www.photosample.common.BaseActivity
import com.daangn.www.photosample.databinding.ActivityPhotoDetailBinding
import javax.inject.Inject

class PhotoDetailActivity: BaseActivity() {

    @Inject
    lateinit var photoDetailViewModelFactory: PhotoDetailViewModelFactory

    lateinit var photoDetailViewModel: PhotoDetailViewModel

    lateinit var binding: ActivityPhotoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_detail)

        photoDetailViewModel = ViewModelProviders.of(this, photoDetailViewModelFactory).get(PhotoDetailViewModel::class.java)
        photoDetailViewModel.getPhotoDetail()
        photoDetailViewModel.state.observe(this, Observer { viewState ->
            binding.title.text = viewState?.title

            Glide.with(this)
                .load(viewState?.thumbnailUrl)
                .into(binding.thumbnailImage)
        })
    }

}