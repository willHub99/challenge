package com.example.masterremotechallenge.activityes

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.masterremotechallenge.R
import com.example.masterremotechallenge.databinding.ActivityMainBinding
import com.example.masterremotechallenge.utils.fromJson
import com.example.masterremotechallenge.utils.toJson
import com.example.masterremotechallenge.viewmodels.MainViewModel


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var viewmodel: MainViewModel
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //set gradient colors
        setGradientMasterText()
        setGradientControlText()

        //configure click event listener
        binding.loginBtn.setOnClickListener(this)
        binding.createAccount.setOnClickListener(this)
        binding.listUsers.setOnClickListener(this)

        //view model
        viewmodel = MainViewModel(applicationContext)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.login_btn) {
            val password = binding.passowrdField.text.toString()
            val email = binding.emailField.text.toString()
            viewmodel.login(email, password)
            viewmodel.loginResult.observe(this, Observer {
                it?.let {
                    val intent = Intent(this, Dashboard::class.java)
                    intent.putExtra("user", it.toJson())
                    startActivity(intent)
                }
            })
        } else if(view.id == R.id.create_account) {
            val intent = Intent(this, CreateUser::class.java)
            startActivity(intent)
        } else if (view.id == R.id.list_users) {
            val intent = Intent(this, ListUser::class.java)
            startActivity(intent)
        }
    }


    private fun setGradientMasterText() {
        val textView = binding.textMaster
        val shader = LinearGradient(
            0f,
            0f,
            90f,
            textView.textSize,
            Color.parseColor("#5619e3"),
            Color.parseColor("#298AD4"),
            Shader.TileMode.CLAMP
        )
        textView.paint.shader = shader
    }

    private fun setGradientControlText() {
        val textView = binding.textControl
        val shader = LinearGradient(
            0f,
            0f,
            90f,
            textView.textSize,
            Color.parseColor("#e6eaed"),
            Color.parseColor("#707273"),
            Shader.TileMode.CLAMP
        )
        textView.paint.shader = shader
    }

}