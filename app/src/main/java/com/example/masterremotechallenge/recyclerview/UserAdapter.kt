package com.example.masterremotechallenge.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.masterremotechallenge.R
import com.example.masterremotechallenge.database.User

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    lateinit var userList: List<User>
    var onItemClick: ((User, Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        holder.emailUser.text = user.email
        holder.nameUser.text = user.name

        holder.btnDelete.setOnClickListener{
            onItemClick?.invoke(user, position)
        }

        setVisibilityViewInFirstUserItemList(position, holder.view)
    }

    private fun setVisibilityViewInFirstUserItemList(position: Int, view: View) {
        if (position == 0) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    fun setListUser(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

}