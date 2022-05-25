package com.example.lostfound.view.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lostfound.R
import com.example.lostfound.view.advert.AdvertActivity
import com.example.lostfound.view.itemdisplay.ItemDisplayActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        findViewById<Button>(R.id.btn_create_a_new_advert).setOnClickListener {
            onButtonCreateANewAdvert()
        }
        findViewById<Button>(R.id.btn_show_all_Lost_and_found_items).setOnClickListener {
            onButtonShowAllLost()
        }
    }

    private fun onButtonShowAllLost() {
        val myIntent = Intent(this, ItemDisplayActivity::class.java)
        startActivity(myIntent)

    }

    private fun onButtonCreateANewAdvert() {
        val myIntent = Intent(this, AdvertActivity::class.java)
        startActivity(myIntent)
    }
}