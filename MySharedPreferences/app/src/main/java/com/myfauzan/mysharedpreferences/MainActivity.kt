package com.myfauzan.mysharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.myfauzan.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mUserPreference: UserPreference
    private lateinit var userModel: UserModel

    private var isPreferenceEmpty = false
    private lateinit var binding: ActivityMainBinding

    private var resultLauncher = registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
        if (result.data != null && result.resultCode == FormUserPreferenceActivity.RESULT_CODE) {
            userModel = result.data?.getParcelableExtra<UserModel>(FormUserPreferenceActivity.EXTRA_RESULT) as UserModel
            populateView(userModel)
            checkForm(userModel)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "My User Preference"

        mUserPreference = UserPreference(this)

        showExistingPreference()

        binding.btnSave.setOnClickListener(this)
    }

    private fun showExistingPreference() {
        userModel = mUserPreference.getUser()
        populateView(userModel)
        checkForm(userModel)
    }

    private fun checkForm(userModel: UserModel) {
        binding.apply {
            when {
                userModel.name.toString().isNotEmpty() -> {
                    btnSave.text = getString(R.string.change)
                    isPreferenceEmpty = false
                }
                else -> {
                        btnSave.text = getString(R.string.save)
                        isPreferenceEmpty = true
                }
            }
        }
    }

    private fun populateView(userModel: UserModel) {
        binding.apply {
            tvName.text = if (userModel.name.toString().isEmpty()) "Tidak Ada" else userModel.name
            tvAge.text = userModel.age.toString().ifEmpty { "Tidak Ada" }
            tvLoveMu.text = if (userModel.isLove) "Ya" else "Tidak"
            tvEmail.text = if (userModel.email.toString().isEmpty()) "Tidak Ada" else userModel.email
            tvPhone.text = if (userModel.phoneNumber.toString().isEmpty()) "Tidak Ada" else userModel.phoneNumber

        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_save) {
            val intent = Intent(this@MainActivity, FormUserPreferenceActivity::class.java)
            when {
                isPreferenceEmpty -> {
                    intent.putExtra(
                        FormUserPreferenceActivity.EXTRA_TYPE_FORM,
                        FormUserPreferenceActivity.TYPE_ADD
                    )
                    intent.putExtra("USER", userModel)
                }
                else -> {
                    intent.putExtra(
                        FormUserPreferenceActivity.EXTRA_TYPE_FORM,
                        FormUserPreferenceActivity.TYPE_EDIT
                    )
                    intent.putExtra("USER", userModel)
                }
            }
            resultLauncher.launch(intent)
        }
    }
}