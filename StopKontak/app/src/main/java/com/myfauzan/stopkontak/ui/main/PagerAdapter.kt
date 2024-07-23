package com.myfauzan.stopkontak.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(private val context: Context, fm: FragmentManager) :
FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> return MonitorFragment()
            1 -> return ButtonFragment()
            else -> {throw IllegalStateException("Unexpected value : $position")}
        }
    }

    override fun getCount(): Int {
        return 2
    }
}