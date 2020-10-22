package com.example.vipersimpledemo.ui.album

import com.example.vipersimpledemo.app.model.Photo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import net.omisoft.aborovskoy.umoriliviper.ui.main.data.AlbumRepo

class AlbumInteractor (private val repo: AlbumRepo) : AlbumContract.Interactor{
    private val compositeDisposable = CompositeDisposable()

    override fun getAlbum(onSuccess: (List<Photo>) -> Unit, onError: (Throwable) -> Unit) {
        val disposable = repo.getAlbums()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(onError)
            .doOnSuccess(onSuccess)
            .subscribe()

        compositeDisposable.add(disposable)
    }
    fun dispose() = compositeDisposable.dispose()


}