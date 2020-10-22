package com.example.vipersimpledemo.app

import android.app.Application
import com.example.vipersimpledemo.app.di.AppComponent
import com.example.vipersimpledemo.app.di.AppModule
import com.example.vipersimpledemo.app.di.DaggerAppComponent


class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}