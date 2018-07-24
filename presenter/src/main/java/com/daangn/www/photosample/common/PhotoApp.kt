package com.daangn.www.photosample.common

import android.app.Activity
import android.app.Application
import com.daangn.www.photosample.di.AppModule
import com.daangn.www.photosample.di.DaggerAppComponent
import com.daangn.www.photosample.di.RetrofitModule
import com.daangn.www.photosample.di.appModules
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import org.koin.android.ext.android.startKoin
import javax.inject.Inject


class PhotoApp: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModules)
        injectAppModule()
    }

    private fun injectAppModule() {
        DaggerAppComponent.builder()
            .appModule(AppModule())
            .retrofitModule(RetrofitModule("https://jsonplaceholder.typicode.com/"))
            .build()
            .inject(this)
    }

    override fun activityInjector() = dispatchingActivityInjector
}