package com.daangn.www.photosample.di

import com.daangn.www.photosample.feature.photodetail.PhotoDetailActivity
import com.daangn.www.photosample.feature.photodetail.PhotoDetailModule
import com.daangn.www.photosample.feature.photolist.PhotoListActivity
import com.daangn.www.photosample.feature.photolist.PhotoListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [PhotoListModule::class])
    abstract fun bindPhotoListActivity(): PhotoListActivity

    @ContributesAndroidInjector(modules = [PhotoDetailModule::class])
    abstract fun bindPhotoDetailActivity(): PhotoDetailActivity
}