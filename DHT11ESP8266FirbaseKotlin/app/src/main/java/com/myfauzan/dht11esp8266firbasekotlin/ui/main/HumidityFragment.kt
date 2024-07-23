package com.myfauzan.dht11esp8266firbasekotlin.ui.main

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.myfauzan.dht11esp8266firbasekotlin.databinding.FragmentHumidityBinding

/**
 * A placeholder fragment containing a simple view.
 */
class HumidityFragment : Fragment() {


    private var _binding: FragmentHumidityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHumidityBinding.inflate(inflater, container, false)
        val root = binding.root

    // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("humidity")

        val mHumidityTextView: TextView = binding.humidityTextView
        val mHumidityProgressBar: ProgressBar = binding.humidityProgressBar
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue().toString().trim()
                mHumidityTextView.setText("$value %")
                mHumidityProgressBar.setProgress(Math.round(value.toFloat()))
                Log.d(ContentValues.TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
        return root
    }

    companion object {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}