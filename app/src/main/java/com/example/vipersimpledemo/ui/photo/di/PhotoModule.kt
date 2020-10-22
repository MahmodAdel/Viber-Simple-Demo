package com.example.vipersimpledemo.ui.photo.di

import com.example.vipersimpledemo.app.di.ActivityScope
import com.example.vipersimpledemo.ui.photo.PhotoActivity
import com.example.vipersimpledemo.ui.photo.PhotoContract
import com.example.vipersimpledemo.ui.photo.PhotoPresenter
import com.example.vipersimpledemo.ui.photo.PhotoRouter
import dagger.Module
import dagger.Provides


@Module
class PhotoModule {

    @Provides
    @ActivityScope
    fun router(activity: PhotoActivity): PhotoContract.Router = PhotoRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: PhotoContract.Router) = PhotoPresenter(router)
}