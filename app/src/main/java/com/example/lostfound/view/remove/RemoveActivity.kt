package com.example.lostfound.view.remove

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lostfound.R
import com.example.lostfound.database.User
import com.example.lostfound.database.UserDB


class RemoveActivity : AppCompatActivity() {
    private lateinit var removeButton: Button
    private lateinit var topTV: TextView
    private lateinit var midTV: TextView
    private lateinit var botTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove)
        initViews()
    }

    private fun initViews() {
        val user = intent.getParcelableExtra<User>("KEY_DELETE_USER")
        removeButton = findViewById(R.id.btn_remove)
        topTV = findViewById(R.id.TVtop)
        midTV = findViewById(R.id.TVmiddle)
        botTV = findViewById(R.id.TVbottom)
        topTV.text = user?.userName
        midTV.text = user?.userDate
        botTV.text = user?.userLocation
        removeButton.setOnClickListener {
            UserDB.getInstance(this).userDao().deleteUser(user!!)
            Toast.makeText(this, "Delete success!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}