package com.myfauzan.dht11esp8266firbasekotlin.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> return TemperatureFragment()
            1 -> return HumidityFragment()
            else -> {throw IllegalStateException("Unexpected value: " + position)}
        }
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}