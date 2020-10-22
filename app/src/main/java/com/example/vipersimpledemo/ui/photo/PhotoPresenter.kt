package com.example.vipersimpledemo.ui.photo

import com.example.vipersimpledemo.app.model.Photo

class PhotoPresenter(private val router: PhotoContract.Router) : PhotoContract.Presenter {

    private var view: PhotoContract.View? = null

    override fun bindView(view: PhotoContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated(photo: Photo?) {
        photo?.let { view?.publishData(it) }
    }

    override fun onEmptyData(msg: Int) {
        view?.showMessage(msg)
        router.finish()
    }

    override fun onBackClicked() {
        router.finish()
    }
}