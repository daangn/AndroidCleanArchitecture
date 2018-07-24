package com.daangn.www.photosample.di

import com.daangn.www.photosample.common.PhotoApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    RetrofitModule::class,
    DataModule::class,
    ActivityBuilder::class
])

interface AppComponent {
   /* @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: PhotoApp): Builder
        fun build(): AppComponent
    }
*/
    fun inject(app: PhotoApp)
}