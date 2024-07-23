package com.myfauzan.dht11esp8266firbasekotlin.ui.main

import android.content.ContentValues.TAG
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
import com.myfauzan.dht11esp8266firbasekotlin.databinding.FragmentTemperatureBinding
import kotlin.math.roundToInt

/**
 * A placeholder fragment containing a simple view.
 */
class TemperatureFragment : Fragment() {


    private var _binding: FragmentTemperatureBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTemperatureBinding.inflate(inflater, container, false)
        val root = binding.root

        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("temperature")

        val mTemperatureTextView: TextView = binding.temperatureTextView
        val mTemperatureProgressBar: ProgressBar = binding.temperatureProgressBar
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString().trim()
                mTemperatureTextView.text = "$value C"
                mTemperatureProgressBar.progress = value.toFloat().roundToInt()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}