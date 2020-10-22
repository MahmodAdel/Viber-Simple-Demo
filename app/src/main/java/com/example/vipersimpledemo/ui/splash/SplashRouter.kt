package com.example.vipersimpledemo.ui.splash

import com.example.vipersimpledemo.ui.album.AlbumsActivity

class SplashRouter(private val activity: SplashActivity):SplashContract.Router{
    override fun openAlbums() {
        AlbumsActivity.launch(activity)
        activity.finish()
    }

}