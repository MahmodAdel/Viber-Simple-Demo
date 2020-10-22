package com.example.vipersimpledemo.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vipersimpledemo.R
import com.example.vipersimpledemo.app.App
import net.omisoft.aborovskoy.umoriliviper.ui.splash.di.DaggerSplashComponent
import net.omisoft.aborovskoy.umoriliviper.ui.splash.di.SplashComponent
import net.omisoft.aborovskoy.umoriliviper.ui.splash.di.SplashModule
import javax.inject.Inject

class SplashActivity : AppCompatActivity() ,SplashContract.View{
    val component: SplashComponent by lazy {
        DaggerSplashComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(SplashModule())
            .build()
    }
    @Inject
    lateinit var presenter: SplashPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }
}