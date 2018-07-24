package com.daangn.www.photosample.di

import com.daangn.www.photosample.feature.photolist.PhotoListActivity
import com.daangn.www.photosample.feature.photolist.PhotoListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [PhotoListModule::class])
    abstract fun bindPhotoListActivity(): PhotoListActivity
}