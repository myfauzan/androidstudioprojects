package com.myfauzan.stopkontak.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.myfauzan.stopkontak.R
import com.myfauzan.stopkontak.data.repository.SettingPreferences
import com.myfauzan.stopkontak.databinding.ActivityThemeBinding
import com.myfauzan.stopkontak.ui.viewmodel.ThemeViewModel

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ThemeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = SettingPreferences.getInstance(dataStore)
        val themeViewModel = ViewModelProvider(this, ViewModelFactory(pref))[ThemeViewModel::class.java]

        themeViewModel.getThemeSettings().observe(this) { isDarkModeActive ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.apply {
                    switchTheme.isChecked = true
                    ivTheme.setImageResource(R.drawable.ic_dark_mode)
                    tvTheme.text = getString(R.string.dark_mode)
                    Toast.makeText(applicationContext, "Dark Mode On", Toast.LENGTH_SHORT).show()
                }
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.apply {
                    switchTheme.isChecked = false
                    ivTheme.setImageResource(R.drawable.ic_wb_sunny)
                    tvTheme.text = getString(R.string.light_mode)
                    Toast.makeText(applicationContext, "Dark Mode Off", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.switchTheme.setOnCheckedChangeListener { _: CompoundButton, isChecked ->
            themeViewModel.saveThemeSetting(isChecked)
        }

        supportActionBar?.title = getString(R.string.title_activity_theme)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}