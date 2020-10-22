package com.example.vipersimpledemo.app.model

import android.os.Parcelable
import androidx.annotation.NonNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val id: Int,
    val albumId: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
) : Parcelable