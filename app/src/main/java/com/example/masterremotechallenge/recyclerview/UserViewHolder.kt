package com.example.masterremotechallenge.recyclerview

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masterremotechallenge.R

class UserViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
    val nameUser: TextView = itemview.findViewById(R.id.name_user)
    val emailUser: TextView = itemview.findViewById(R.id.email_user)
    val view: View = itemview.findViewById(R.id.view)
    val btnDelete: ImageButton = itemview.findViewById(R.id.delete_user)

}