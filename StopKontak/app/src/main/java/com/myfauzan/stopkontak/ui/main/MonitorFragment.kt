package com.myfauzan.stopkontak.ui.main

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.myfauzan.stopkontak.databinding.FragmentMonitorBinding

class MonitorFragment : Fragment() {

    private var _binding: FragmentMonitorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        _binding = FragmentMonitorBinding.inflate(inflater, container, false)
        val root = binding.root

        // Write a message to the database
        val myRefPower = FirebaseDatabase.getInstance().getReference("nilai/power")
        val mPowerTextView: TextView = binding.powerTextView
        val mPowerProgressBar: ProgressBar = binding.powerProgressBar
        myRefPower.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString().trim()

                try {
                    val floatValue = value.toFloat()
                    val progressValue = floatValue * 1000
                    val progress = progressValue.toInt()
                    mPowerTextView.text = String.format("%.2f W", floatValue)
                    mPowerProgressBar.progress = progress
                    Log.d(ContentValues.TAG, "Value is: $value")
                } catch (e: NumberFormatException) {
                    // Handle non-numeric values
                    mPowerTextView.text = "0 W"
                    mPowerProgressBar.progress = 0
                    Log.w(ContentValues.TAG, "Invalid value: $value")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })

        val myRefEnergy = FirebaseDatabase.getInstance().getReference("nilai/energy")
        val mEnergyTextView: TextView = binding.energyTextView
        val mEnergyProgressBar: ProgressBar = binding.energyProgressBar
        myRefEnergy.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString().trim()
                try {
                    val floatValue = value.toFloat()
                    val progressValue = floatValue * 1000
                    val progress = progressValue.toInt()
                    mEnergyTextView.text = String.format("%.2f kWh", floatValue)
                    mEnergyProgressBar.progress = progress
                    Log.d(ContentValues.TAG, "Value is: $value")
                } catch (e: NumberFormatException) {
                    // Handle non-numeric values
                    mEnergyTextView.text = "0 kWh"
                    mEnergyProgressBar.progress = 0
                    Log.w(ContentValues.TAG, "Invalid value: $value")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })

        val myRefVoltage = FirebaseDatabase.getInstance().getReference("nilai/voltage")
        val mVoltageTextView: TextView = binding.voltageTextView
        val mVoltageProgressBar: ProgressBar = binding.voltageProgressBar
        myRefVoltage.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString().trim()

                try {
                    val floatValue = value.toFloat()
                    val progressValue = floatValue * 1000
                    val progress = progressValue.toInt()
                    mVoltageTextView.text = String.format("%.2f V", floatValue)
                    mVoltageProgressBar.progress = progress
                    Log.d(ContentValues.TAG, "Value is: $value")
                } catch (e: NumberFormatException) {
                    // Handle non-numeric values
                    mVoltageTextView.text = "0 V"
                    mVoltageProgressBar.progress = 0
                    Log.w(ContentValues.TAG, "Invalid value: $value")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })

        val myRefCurrent = FirebaseDatabase.getInstance().getReference("nilai/current")
        val mCurrentTextView: TextView = binding.currentTextView
        val mCurrentProgressBar: ProgressBar = binding.currentProgressBar
        myRefCurrent.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString().trim()

                try {
                    val floatValue = value.toFloat()
                    val progressValue = floatValue * 1000
                    val progress = progressValue.toInt()
                    mCurrentTextView.text = String.format("%.2f A", floatValue)
                    mCurrentProgressBar.progress = progress
                    Log.d(ContentValues.TAG, "Value is: $value")
                } catch (e: NumberFormatException) {
                    // Handle non-numeric values
                    mCurrentTextView.text = "0 A"
                    mCurrentProgressBar.progress = 0
                    Log.w(ContentValues.TAG, "Invalid value: $value")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}