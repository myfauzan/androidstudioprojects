package com.myfauzan.githubuserapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        shoRecyclerList()

    }

    private val listUsers: ArrayList<User>
    @SuppressLint("Recycle")
    get() {
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val listUser = ArrayList<User>()
        for (i in dataUsername.indices){
            val user = User(
                dataAvatar.getResourceId(i, -1),
                dataUsername[i],
                dataName[i],
                dataCompany[i],
                dataLocation[i],
                dataRepository[i],
                dataFollower[i],
                dataFollowing[i]
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun shoRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{

            override fun onItemClicked(data: User) {
                showSelectedAlbum(data)
            }
        })
    }

    private fun showSelectedAlbum(user: User) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(INTENT_PARCELABLE, user)
        startActivity(intent)
        Toast.makeText(this, "Kamu memilih " + user.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, 1 , Menu.NONE, "Dark Mode")
        menu?.add(Menu.NONE, 2 , Menu.NONE, "Light Mode")
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        return super.onOptionsItemSelected(item)
    }
    companion object{
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
}