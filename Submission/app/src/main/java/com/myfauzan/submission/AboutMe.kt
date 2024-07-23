package com.myfauzan.submission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setActionBarTitle(title = "About Me")
    }
    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean{
        onBackPressed()
        return true
    }
}