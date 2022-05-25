package com.example.lostfound.view.itemdisplay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lostfound.R
import com.example.lostfound.database.User
import com.example.lostfound.database.UserDB
import com.example.lostfound.view.itemdisplay.adapter.MyRecyclerViewAdapter
import com.example.lostfound.view.remove.RemoveActivity


class ItemDisplayActivity : AppCompatActivity(), MyRecyclerViewAdapter.OnItemClickListener {
    lateinit var rvLostFound: RecyclerView
    private lateinit var mListUser: List<User>
    lateinit var userAdapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_display)
        initViews()
        userAdapter = MyRecyclerViewAdapter(this)
        mListUser = mutableListOf()
        userAdapter.setData(mListUser)
        val layout: LinearLayoutManager = LinearLayoutManager(this)
        rvLostFound.layoutManager = layout
        rvLostFound.adapter = userAdapter
        fetchData()
    }

    override fun onRestart() {
        super.onRestart()
        fetchData()
    }

    private fun fetchData() {
        mListUser = UserDB.getInstance(this).userDao().getListUser()
        userAdapter.setData(mListUser)
    }

    private fun initViews() {
        rvLostFound = findViewById(R.id.rv_lost_found)

    }

    override fun onItemClick(position: Int, user: User) {
        val myIntent = Intent(this, RemoveActivity::class.java)
        myIntent.putExtra("KEY_DELETE_USER", user)
        startActivity(myIntent)
    }
}