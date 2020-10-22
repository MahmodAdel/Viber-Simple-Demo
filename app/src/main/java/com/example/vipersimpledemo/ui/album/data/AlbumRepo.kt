package net.omisoft.aborovskoy.umoriliviper.ui.main.data

import com.example.vipersimpledemo.app.model.Photo
import com.example.vipersimpledemo.ui.album.AlbumContract
import io.reactivex.Single
import net.omisoft.aborovskoy.umoriliviper.ui.main.api.MainApi


class AlbumRepo(private val api: MainApi) : AlbumContract.Repo {

    override fun getAlbums(): Single<List<Photo>> = api.getAlbums()

}