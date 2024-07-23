package com.myfauzan.submission

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailAlbumActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_album)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val album = intent.getParcelableExtra<Album>(MainActivity.INTENT_PARCELABLE)

        val imgAlbum = findViewById<ImageView>(R.id.img_item_photo)
        val nameAlbum = findViewById<TextView>(R.id.tv_item_name)
        val detailAlbum = findViewById<TextView>(R.id.tv_item_detail)

        imgAlbum.setImageResource(album?.photo!!)
        nameAlbum.text = album.name
        detailAlbum.text = album.detail

        setActionBarTitle(title = "Detail Album")
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean{
        onBackPressed()
        return true
    }
}