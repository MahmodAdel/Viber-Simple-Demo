package com.example.vipersimpledemo.ui.photo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.vipersimpledemo.BuildConfig
import com.example.vipersimpledemo.R
import com.example.vipersimpledemo.app.App
import com.example.vipersimpledemo.app.model.Photo
import com.example.vipersimpledemo.ui.photo.di.DaggerPhotoComponent
import com.example.vipersimpledemo.ui.photo.di.PhotoComponent
import com.example.vipersimpledemo.ui.photo.di.PhotoModule
import kotlinx.android.synthetic.main.activity_photo.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class PhotoActivity : AppCompatActivity(),PhotoContract.View {

    companion object {
        private const val ALBUM = "${BuildConfig.APPLICATION_ID}ALBUM"

        fun launch(context: Context, data: Photo) {
            val intent = Intent(context, PhotoActivity::class.java)
            intent.putExtra(ALBUM, data)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: PhotoPresenter

    val component: PhotoComponent by lazy {
        DaggerPhotoComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(PhotoModule())
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        initView()
        component.inject(this)
        presenter.bindView(this)
        if (intent.hasExtra(ALBUM)) {
            intent.getParcelableExtra<Photo>(ALBUM)
            presenter.onViewCreated(intent.getParcelableExtra(ALBUM))
        } else {
            presenter.onEmptyData(R.string.empty_data)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun publishData(joke: Photo) {
        name.text = joke.title

    }

    override fun showMessage(msg: Int) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        toolbar.setTitle(R.string.detail_title)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        toolbar.setNavigationOnClickListener { presenter.onBackClicked() }
    }
}