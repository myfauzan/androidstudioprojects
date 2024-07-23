package com.myfauzan.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val user = intent.getParcelableExtra<User>(MainActivity.INTENT_PARCELABLE)

        val imgAvatar = findViewById<ImageView>(R.id.img_avatar)
        val tvUsername = findViewById<TextView>(R.id.tv_username)
        val tvNameuser = findViewById<TextView>(R.id.tv_name)
        val tvCompany = findViewById<TextView>(R.id.tv_company)
        val tvLocation = findViewById<TextView>(R.id.tv_location)
        val tvRepository = findViewById<TextView>(R.id.tv_repository)
        val tvFollower = findViewById<TextView>(R.id.tv_follower)
        val tvFollowing = findViewById<TextView>(R.id.tv_following)

        imgAvatar.setImageResource(user?.avatar!!)
        tvUsername.text = user.username
        tvNameuser.text = user.name
        tvCompany.text = user.company
        tvLocation.text = user.location
        tvRepository.text = user.repository
        tvFollower.text = user.follower
        tvFollowing.text = user.following

        setActionBarTitle(title = StringBuilder("Detail ").append(user.name).toString())
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean{
        onBackPressed()
        return true
    }
}