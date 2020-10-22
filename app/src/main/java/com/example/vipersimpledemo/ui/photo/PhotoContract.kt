package com.example.vipersimpledemo.ui.photo

import com.example.vipersimpledemo.app.model.Photo


interface PhotoContract {
    interface View {
        fun publishData(photo: Photo)

        fun showMessage(msg: Int)
    }

    interface Presenter {
        fun bindView(view: PhotoContract.View)

        fun unbindView()

        fun onViewCreated(photo: Photo?)

        fun onBackClicked()

        fun onEmptyData(msg: Int)
    }

    interface Router {
        fun finish()
    }
}