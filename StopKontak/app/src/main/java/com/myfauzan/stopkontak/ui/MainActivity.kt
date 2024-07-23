package com.myfauzan.stopkontak.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.myfauzan.stopkontak.R
import com.myfauzan.stopkontak.data.repository.SettingPreferences
import com.myfauzan.stopkontak.databinding.ActivityMainBinding
import com.myfauzan.stopkontak.ui.main.PagerAdapter
import com.myfauzan.stopkontak.ui.viewmodel.MainViewModel

private  val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var toogle: ActionBarDrawerToggle

    private lateinit var profileImageView: ImageView
    private var profileImageUrl: String = "profil_kotak"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = SettingPreferences.getInstance(dataStore)
        viewModel = ViewModelProvider(this, ViewModelFactory(pref))[MainViewModel::class.java]

        viewModel.getThemeSettings().observe(this) { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        val pagerAdapter = PagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = pagerAdapter

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navigationView

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        profileImageView = navView.getHeaderView(0).findViewById(R.id.iv_profilePicture)
        Glide.with(this)
            .load(resources.getIdentifier(profileImageUrl, "drawable", packageName))
            .circleCrop()
            .into(profileImageView)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.google_sheet -> {
                    val url = "https://docs.google.com/spreadsheets/d/17wlfAgIB24ZGHm4DoYofsUw7URwS81sVoYZnVnW53oc/edit#gid=0"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                    Toast.makeText(applicationContext, "Clicked Google Sheet", Toast.LENGTH_SHORT).show()
                }
                R.id.settings -> {
                    val intent = Intent(this, ThemeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(applicationContext, "Clicked Settings", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}