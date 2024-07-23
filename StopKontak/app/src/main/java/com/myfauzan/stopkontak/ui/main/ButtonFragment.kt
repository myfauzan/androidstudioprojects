package com.myfauzan.stopkontak.ui.main

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.myfauzan.stopkontak.R
import com.myfauzan.stopkontak.databinding.FragmentButtonBinding

class ButtonFragment : Fragment() {

    private var _binding: FragmentButtonBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentButtonBinding.inflate(inflater, container, false)
        val root = binding.root

        // Write a message to the database
        val myRefElectric1 = FirebaseDatabase.getInstance().getReference("terminal/a")
        val mElectric1: SwitchMaterial = binding.switchElectric1
        val mImageElectric1: ImageView = binding.ivElectric1
        myRefElectric1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString().toBooleanStrict()
                mElectric1.isChecked = value
                if (mElectric1.isChecked) {
                    context?.let { ContextCompat.getColor(it, R.color.orange_200) }
                        ?.let { mImageElectric1.setColorFilter(it, android.graphics.PorterDuff.Mode.SRC_IN) }
                }
                else {
                    mImageElectric1.clearColorFilter()
                }
                Log.d(ContentValues.TAG, "Value is: $value")
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
        mElectric1.setOnCheckedChangeListener{ _: CompoundButton, isChecked ->
            if (isChecked) {
                myRefElectric1.setValue(true)
            }
            else {
                myRefElectric1.setValue(false)
            }
        }

        val myRefElectric2 = FirebaseDatabase.getInstance().getReference("terminal/b")
        val mElectric2: SwitchMaterial = binding.switchElectric2
        val mImageElectric2: ImageView = binding.ivElectric2
        myRefElectric2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString().toBooleanStrict()
                mElectric2.isChecked = value
                if (mElectric2.isChecked) {
                    context?.let { ContextCompat.getColor(it, R.color.orange_200) }
                        ?.let { mImageElectric2.setColorFilter(it, android.graphics.PorterDuff.Mode.SRC_IN) }
                }
                else {
                    mImageElectric2.clearColorFilter()
                }
                Log.d(ContentValues.TAG, "Value is: $value")
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
        mElectric2.setOnCheckedChangeListener{ _: CompoundButton, isChecked ->
            if (isChecked) {
                myRefElectric2.setValue(true)
            }
            else {
                myRefElectric2.setValue(false)
            }
        }

        val myRefElectric3 = FirebaseDatabase.getInstance().getReference("terminal/c")
        val mElectric3: SwitchMaterial = binding.switchElectric3
        val mImageElectric3: ImageView = binding.ivElectric3
        myRefElectric3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value.toString().toBooleanStrict()
                mElectric3.isChecked = value
                if (mElectric3.isChecked) {
                    context?.let { ContextCompat.getColor(it, R.color.orange_200) }
                        ?.let { mImageElectric3.setColorFilter(it, android.graphics.PorterDuff.Mode.SRC_IN) }
                }
                else {
                    mImageElectric3.clearColorFilter()
                }
                Log.d(ContentValues.TAG, "Value is: $value")
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
        mElectric3.setOnCheckedChangeListener{ _: CompoundButton, isChecked ->
            if (isChecked) {
                myRefElectric3.setValue(true)
            }
            else {
                myRefElectric3.setValue(false)
            }
        }
        return root
    }
}