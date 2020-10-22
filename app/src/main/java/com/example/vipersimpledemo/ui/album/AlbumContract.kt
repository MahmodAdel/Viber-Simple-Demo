package com.example.vipersimpledemo.ui.album

import com.example.vipersimpledemo.app.model.Photo
import io.reactivex.Single

interface AlbumContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<Photo>)
        fun showMessage(msg: String)
    }

    interface Presenter {

        fun bindView(view: AlbumContract.View)

        fun unbindView()

        fun onViewCreated()

        fun onItemClicked(photo: Photo)

        fun onBackClicked()
    }

    interface Interactor {
        fun getAlbum(onSuccess: (List<Photo>) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()
        fun openFullAlbum(photo: Photo)
    }

    interface Repo {
        fun getAlbums(): Single<List<Photo>>
    }
}