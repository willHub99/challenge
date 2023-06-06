package com.example.masterremotechallenge.activityes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.masterremotechallenge.R
import com.example.masterremotechallenge.database.User
import com.example.masterremotechallenge.databinding.ActivityCreateUserBinding
import com.example.masterremotechallenge.viewmodels.CreateUserViewModel
import java.util.UUID

class CreateUser : AppCompatActivity(), View.OnClickListener {
    lateinit var viewmodel: CreateUserViewModel
    private val binding: ActivityCreateUserBinding by lazy {
        ActivityCreateUserBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //configure click event listener
        binding.saveDataUser.setOnClickListener(this)

        //view model
        viewmodel = CreateUserViewModel(applicationContext)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.save_data_user) {
            val email = binding.emailFieldCreateUser.text.toString()
            val password = binding.passwordFieldCreateUser.text.toString()
            val name = binding.nameFieldCreateUser.text.toString()
            val phone = binding.phoneFieldCreateUser.text.toString()
            val id = UUID.randomUUID().toString()

            val user = User(
                id,
                name,
                email,
                phone,
                password,
                false
            )
            viewmodel.createUser(user)
            viewmodel.createUserResult.observe(this, Observer {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            })
        }
    }
}