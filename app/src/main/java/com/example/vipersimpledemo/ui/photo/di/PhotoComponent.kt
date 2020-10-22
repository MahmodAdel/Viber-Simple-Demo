package com.example.vipersimpledemo.ui.photo.di

import com.example.vipersimpledemo.app.di.ActivityScope
import com.example.vipersimpledemo.app.di.AppComponent
import com.example.vipersimpledemo.ui.photo.PhotoActivity
import dagger.BindsInstance
import dagger.Component


@ActivityScope
@Component(modules = [PhotoModule::class], dependencies = [AppComponent::class])
interface PhotoComponent {

    fun inject(target: PhotoActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: PhotoActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: PhotoModule): Builder

        fun build(): PhotoComponent
    }
}