package com.example.vipersimpledemo.ui.photo

class PhotoRouter(private val activity: PhotoActivity) : PhotoContract.Router {
    override fun finish() {
        activity.finish()
    }
}