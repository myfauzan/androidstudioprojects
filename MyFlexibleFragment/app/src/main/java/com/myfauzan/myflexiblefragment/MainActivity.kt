package com.myfauzan.myflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment){
            Log.d("MyFlexibleFragment", "Fragment Name : " + HomeFragment::class.java.simpleName)
            mFragmentManager.commit {
                add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
            }

        }
    }
}