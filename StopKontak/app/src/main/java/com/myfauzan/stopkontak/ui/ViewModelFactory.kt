package com.myfauzan.stopkontak.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myfauzan.stopkontak.data.repository.SettingPreferences
import com.myfauzan.stopkontak.ui.viewmodel.MainViewModel
import com.myfauzan.stopkontak.ui.viewmodel.ThemeViewModel

class ViewModelFactory(private val pref: SettingPreferences) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(pref) as T
        } else if (modelClass.isAssignableFrom(ThemeViewModel::class.java)) {
            return ThemeViewModel(pref) as T
        }
        throw  IllegalArgumentException("Unknown ViewlModel class : ${modelClass.name}")
    }
}