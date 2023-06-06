package com.example.masterremotechallenge.activityes

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masterremotechallenge.R
import com.example.masterremotechallenge.database.User
import com.example.masterremotechallenge.databinding.ActivityListUserBinding
import com.example.masterremotechallenge.recyclerview.UserAdapter
import com.example.masterremotechallenge.viewmodels.ListUserViewModel

class ListUser : AppCompatActivity() {

    private val adapter: UserAdapter by lazy {
        UserAdapter()
    }
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rv_users)
    }

    private val binding: ActivityListUserBinding by lazy {
        ActivityListUserBinding.inflate(layoutInflater)
    }

    lateinit var viewModel: ListUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ListUserViewModel(applicationContext)

        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        viewModel.getAllUser()
        viewModel.getAllUsersResult.observe(this, Observer { it ->
            if (it != null) {
                recyclerView.layoutManager = LinearLayoutManager(this)
                adapter.setListUser(it)
                recyclerView.adapter = adapter
            }
        })
        adapter.onItemClick = { user, position ->
            alertDialog(binding.root, user)
        }
    }


    private fun alertDialog(view: View, user: User){
        val alert = AlertDialog.Builder(view.context)
        alert.setTitle("Tem certeza que deseja remover este usuário ?")
        alert.setPositiveButton("Sim") { _, _ ->
            viewModel.deleteUser(user)
        }
        alert.setNegativeButton("Não") { _, _ ->

        }

        alert.show()

    }

}