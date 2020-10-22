package net.omisoft.aborovskoy.umoriliviper.ui.splash.di

import com.example.vipersimpledemo.app.di.ActivityScope
import com.example.vipersimpledemo.app.di.AppComponent
import com.example.vipersimpledemo.ui.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [SplashModule::class], dependencies = [AppComponent::class])
interface SplashComponent {

    fun inject(target: SplashActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: SplashActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: SplashModule): Builder

        fun build(): SplashComponent
    }
}