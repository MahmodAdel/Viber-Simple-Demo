package net.omisoft.aborovskoy.umoriliviper.ui.splash.di

import com.example.vipersimpledemo.app.di.ActivityScope
import com.example.vipersimpledemo.ui.splash.SplashActivity
import com.example.vipersimpledemo.ui.splash.SplashContract
import com.example.vipersimpledemo.ui.splash.SplashPresenter
import com.example.vipersimpledemo.ui.splash.SplashRouter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    @ActivityScope
    fun router(activity: SplashActivity): SplashContract.Router = SplashRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: SplashContract.Router) = SplashPresenter(router)
}