package com.example.lostfound.view.advert

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lostfound.R
import com.example.lostfound.database.User
import com.example.lostfound.database.UserDB

class AdvertActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var descriptionEditText: EditText
    lateinit var dateEditText: EditText
    lateinit var locationEditText: EditText
    lateinit var radioLost: RadioButton
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advert)
        initViews()

    }

    private fun initViews() {
        saveButton = findViewById(R.id.btn_save)
        nameEditText = findViewById(R.id.editTextName)
        phoneEditText = findViewById(R.id.editTextPhone)
        descriptionEditText = findViewById(R.id.editTextDescription)
        dateEditText = findViewById(R.id.editTextDate)
        locationEditText = findViewById(R.id.editTextLocation)
        radioLost = findViewById(R.id.radio_lost)
        saveButton.setOnClickListener {
            onSaveButton()
        }
    }

    private fun onSaveButton() {
        val name: String = nameEditText.text.toString()
        val phone: String = phoneEditText.text.toString()
        val description: String = descriptionEditText.text.toString()
        val date: String = dateEditText.text.toString()
        val location: String = locationEditText.text.toString()
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(description) || TextUtils.isEmpty(
                date
            ) || TextUtils.isEmpty(location)
        ) {
            return
        }
        val status = if (radioLost.isChecked) {
            "Lost"
        } else {
            "Found"
        }
        val user = User(name, phone, description, date, location, status)
        UserDB.getInstance(this).userDao().insertUser(user)
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        finish()
    }
}