package com.myfauzan.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.myfauzan.mylivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mLiveDataTimerViewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        mLiveDataTimerViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        activityMainBinding.btnSubmit.setOnClickListener(this)

    }

    private fun subscribe() {
        val standby = 20
        val input = activityMainBinding.edtInput.text.toString().trim()
        if (input.toInt() < standby) {
            val elapsedTimeObserver = Observer<Long?> { aLong ->
                val newText = this@MainActivity.resources.getString(R.string.seconds, aLong)
                activityMainBinding.timerTextview.text = newText
            }

            mLiveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
        }
        else {

        }
    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.btn_submit -> subscribe()
        }
    }
}