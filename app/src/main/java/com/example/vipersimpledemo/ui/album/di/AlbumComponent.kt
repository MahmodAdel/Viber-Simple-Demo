package com.example.vipersimpledemo.ui.album.di

import com.example.vipersimpledemo.app.di.ActivityScope
import com.example.vipersimpledemo.app.di.AppComponent
import com.example.vipersimpledemo.ui.album.AlbumsActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [AlbumModule::class], dependencies = [AppComponent::class])
interface AlbumComponent {

    fun inject(target: AlbumsActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: AlbumsActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: AlbumModule): Builder

        fun build(): AlbumComponent
    }
}