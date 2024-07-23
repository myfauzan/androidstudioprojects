package com.myfauzan.submission

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewAlbumAdapter (private val listAlbum: ArrayList<Album>) : RecyclerView.Adapter<CardViewAlbumAdapter.CardViewViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Album)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardViewAlbumAdapter.CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_album,parent,false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewAlbumAdapter.CardViewViewHolder, position: Int) {
        val album = listAlbum[position]

        Glide.with(holder.itemView.context)
            .load(album.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = album.name
        holder.tvDetail.text = album.detail

        holder.btnFavorite.setOnCheckedChangeListener { itemView, isChecked ->
            if (itemView.isChecked) {
                Toast.makeText(
                    holder.itemView.context,
                    "Favorite " + listAlbum[holder.adapterPosition].name,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    holder.itemView.context,
                    "Unfavorite " + listAlbum[holder.adapterPosition].name,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        holder.btnShare.setOnClickListener{
            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, listAlbum[holder.adapterPosition].photo)
                type = "image/*"
            }
            startActivity(holder.itemView.context, Intent.createChooser(shareIntent,"Share To..."),
                null)
            //ContextCompat.startActivity(Intent.createChooser(shareIntent, "Share images to ..."))
            Toast.makeText(holder.itemView.context, "Share " + listAlbum[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listAlbum[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listAlbum.size
    }


    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var btnFavorite: CheckBox = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.action_share)
    }
}