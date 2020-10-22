package com.example.vipersimpledemo.ui.album

import com.example.vipersimpledemo.app.model.Photo
import com.example.vipersimpledemo.ui.photo.PhotoActivity

class AlbumRouter(private val activity: AlbumsActivity) : AlbumContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun openFullAlbum(photo: Photo) {
        PhotoActivity.launch(activity, photo)
    }


}