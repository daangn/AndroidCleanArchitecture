package com.daangn.www.photosample.di

import com.daangn.www.photosample.common.PhotoApp
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    internal fun provideContext(app: PhotoApp) = app.applicationContext
}