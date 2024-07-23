package com.myfauzan.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var album: RecyclerView
    private var list: ArrayList<Album> = arrayListOf()
    private var title: String = "Mode List"

    companion object{
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        album = findViewById(R.id.album_music)
        album.setHasFixedSize(true)

        list.addAll(AlbumData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        album.layoutManager = LinearLayoutManager(this)
        val listAlbumAdapter = ListAlbumAdapter(list)
        album.adapter = listAlbumAdapter

        listAlbumAdapter.setOnItemClickCallback(object : ListAlbumAdapter.OnItemClickCallback{

            override fun onItemClicked(data: Album) {
                showSelectedAlbum(data)
            }
        })
    }

    private fun showRecyclerGrid(){
        album.layoutManager = GridLayoutManager(this, 2)
        val gridAlbumAdapter = GridAlbumAdapter(list)
        album.adapter = gridAlbumAdapter

        gridAlbumAdapter.setOnItemClickCallback(object : GridAlbumAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Album) {
                showSelectedAlbum(data)
            }
        })
    }

    private fun showRecyclerCardView(){
        album.layoutManager = LinearLayoutManager(this)
        val cardViewAlbumAdapter = CardViewAlbumAdapter(list)
        album.adapter = cardViewAlbumAdapter

        cardViewAlbumAdapter.setOnItemClickCallback(object : CardViewAlbumAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Album) {
                showSelectedAlbum(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode){
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }

            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }

            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }

            R.id.action_about_page -> {
                val moveIntent = Intent(this, AboutMe::class.java)
                startActivity(moveIntent)
            }
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    private fun showSelectedAlbum(album: Album){
        val intent = Intent(this@MainActivity, DetailAlbumActivity::class.java)
        intent.putExtra(INTENT_PARCELABLE, album)
        startActivity(intent)
        Toast.makeText(this, "Kamu memilih " + album.name, Toast.LENGTH_SHORT).show()
    }
}