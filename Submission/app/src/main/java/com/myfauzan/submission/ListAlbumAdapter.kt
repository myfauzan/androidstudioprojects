package com.myfauzan.submission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAlbumAdapter (private val listAlbum: ArrayList<Album>): RecyclerView.Adapter<ListAlbumAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Album)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_album_music,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val album = listAlbum[position]

        Glide.with(holder.itemView.context)
            .load(album.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.albmPhoto)

        holder.albmName.text = album.name
        holder.albmDetail.text = album.detail

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listAlbum[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listAlbum.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var albmName: TextView = itemView.findViewById(R.id.name_album)
        var albmDetail: TextView = itemView.findViewById(R.id.album_detail)
        var albmPhoto: ImageView = itemView.findViewById(R.id.photo_album)
    }


}