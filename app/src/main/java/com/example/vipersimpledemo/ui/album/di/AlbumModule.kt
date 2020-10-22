package com.example.vipersimpledemo.ui.album.di

import com.example.vipersimpledemo.app.di.ActivityScope
import com.example.vipersimpledemo.ui.album.*
import dagger.Module
import dagger.Provides
import net.omisoft.aborovskoy.umoriliviper.ui.main.api.MainApi
import net.omisoft.aborovskoy.umoriliviper.ui.main.data.AlbumRepo
import retrofit2.Retrofit

@Module
class AlbumModule {

    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit) = retrofit.create(MainApi::class.java)

    @Provides
    @ActivityScope
    fun repository(api: MainApi) = AlbumRepo(api)


    @Provides
    @ActivityScope
    fun router(activity: AlbumsActivity): AlbumContract.Router = AlbumRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: AlbumContract.Router, interactor: AlbumInteractor) = AlbumPresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repository: AlbumRepo) = AlbumInteractor(repository)
}