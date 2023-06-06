package com.example.masterremotechallenge.activityes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import androidx.core.widget.CompoundButtonCompat
import com.example.masterremotechallenge.R
import com.example.masterremotechallenge.database.User
import com.example.masterremotechallenge.databinding.ActivityDashboardBinding
import com.example.masterremotechallenge.databinding.ActivityMainBinding
import com.example.masterremotechallenge.utils.fromJson

class Dashboard : AppCompatActivity(), View.OnClickListener {
    private val binding: ActivityDashboardBinding by lazy {
        ActivityDashboardBinding.inflate(layoutInflater)
    }
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getUser()
        listenerSwitch()

        //configure click event listener
        binding.btnLogout.setOnClickListener(this)
    }

    private fun getUser(){
        val bundle: Bundle? = intent.extras
        bundle?.getString("user")?.let {
            user = it.fromJson()
            configureFieldValue(user)
        }
    }

    private fun configureFieldValue(user: User) {
        binding.email.text = user.email
        binding.name.text = user.name
        binding.phone.text = user.phone
        binding.switch1.isChecked = true
    }

    fun listenerSwitch() {
        binding.switch1?.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Online" else "Offline"
            binding.value.text = message
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_logout) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}