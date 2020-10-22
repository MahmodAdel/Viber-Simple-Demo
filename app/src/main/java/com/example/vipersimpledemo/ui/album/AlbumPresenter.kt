package com.example.vipersimpledemo.ui.album

import com.example.vipersimpledemo.app.model.Photo

class AlbumPresenter (private val router: AlbumContract.Router, private val interactor: AlbumInteractor) :
    AlbumContract.Presenter {
    private var view: AlbumContract.View? = null

    override fun bindView(view: AlbumContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
        interactor.dispose()
    }

    override fun onViewCreated() {
        view?.showLoading()
        interactor.getAlbum({
            view?.hideLoading()
            view?.publishData(it)
        }, this::onError)
    }

    override fun onItemClicked(photo: Photo) {
        router.openFullAlbum(photo)
    }

    override fun onBackClicked() {
        router.finish()
    }

    private fun onError(error: Throwable) {
        view?.hideLoading()
        error.message?.let { view?.showMessage(it) }
    }

}