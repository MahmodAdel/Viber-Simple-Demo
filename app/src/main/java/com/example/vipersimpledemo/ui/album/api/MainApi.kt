package net.omisoft.aborovskoy.umoriliviper.ui.main.api

import com.example.vipersimpledemo.app.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface MainApi {


    @GET("photos")
    fun getAlbums(): Single<List<Photo>>
}