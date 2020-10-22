package com.example.vipersimpledemo.ui.album

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vipersimpledemo.R
import com.example.vipersimpledemo.app.App
import com.example.vipersimpledemo.app.model.Photo
import com.example.vipersimpledemo.ui.album.di.AlbumComponent
import com.example.vipersimpledemo.ui.album.di.AlbumModule
import com.example.vipersimpledemo.ui.album.di.DaggerAlbumComponent
import kotlinx.android.synthetic.main.activity_albums.*
import kotlinx.android.synthetic.main.toolbar.*
import net.omisoft.aborovskoy.umoriliviper.ui.main.adapter.MainAdapter
import javax.inject.Inject

class AlbumsActivity : AppCompatActivity(),AlbumContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, AlbumsActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: AlbumPresenter
    val component: AlbumComponent by lazy {
        DaggerAlbumComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(AlbumModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        initView()
        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun showLoading() {
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        recyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun publishData(data: List<Photo>) {
        val adapter = MainAdapter(data, object : MainAdapter.JokeListener {
            override fun onItemClick(joke: Photo) {
                presenter.onItemClicked(joke)
            }
        })
        recyclerView.adapter = adapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        val manager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
        recyclerView.layoutManager = manager
        toolbar.setTitle(R.string.main_title)
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        toolbar.setNavigationOnClickListener { presenter.onBackClicked() }
    }
}