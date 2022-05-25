package com.example.lostfound.view.itemdisplay.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lostfound.R
import com.example.lostfound.database.User


class MyRecyclerViewAdapter(var listener: OnItemClickListener) :

    RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {
    private lateinit var listUser: List<User>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_lost_found, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listUser: List<User>) {
        this.listUser = listUser
        notifyDataSetChanged()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = listUser[position] ?: return
        holder.status.text = user.userStatus
        holder.name.text = user.userName
        holder.phone.text = "Phone: " + user.userPhone
        holder.description.text = "Description: " + user.userDescription
        holder.date.text = "Date: " + user.userDate
        holder.location.text = "Location: " + user.userLocation
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var name: TextView = itemView.findViewById(R.id.txt_name)
        var phone: TextView = itemView.findViewById(R.id.txt_phone)
        var description: TextView = itemView.findViewById(R.id.txt_description)
        var date: TextView = itemView.findViewById(R.id.txt_date)
        var location: TextView = itemView.findViewById(R.id.txt_location)
        val status: TextView = itemView.findViewById(R.id.txt_status)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, listUser[position])

            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, user: User)
    }
}

