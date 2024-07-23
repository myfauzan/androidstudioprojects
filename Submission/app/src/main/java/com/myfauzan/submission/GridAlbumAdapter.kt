package com.myfauzan.submission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridAlbumAdapter(val listAlbum: ArrayList<Album>): RecyclerView.Adapter<GridAlbumAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Album)
    }


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridAlbumAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_album, parent,false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridAlbumAdapter.GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listAlbum[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listAlbum[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listAlbum.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }



}