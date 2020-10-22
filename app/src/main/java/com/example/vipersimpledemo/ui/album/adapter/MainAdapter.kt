package net.omisoft.aborovskoy.umoriliviper.ui.main.adapter

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vipersimpledemo.R
import com.example.vipersimpledemo.app.model.Photo
import kotlinx.android.synthetic.main.item_album.view.*


class MainAdapter(private val jokes: List<Photo>, private val listener: JokeListener) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = jokes[position].title
        holder.site.text = jokes[position].thumbnailUrl
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.desc.text = Html.fromHtml(jokes[position].url, Html.FROM_HTML_MODE_LEGACY)
        } else {
            holder.desc.text = (Html.fromHtml(jokes[position].url))
        }

        holder.itemView.setOnClickListener { listener.onItemClick(jokes[position]) }
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.name!!
        val desc = itemView.desc!!
        val site = itemView.site!!
    }

    interface JokeListener {
        fun onItemClick(joke: Photo)
    }
}
