package com.example.masterremotechallenge.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.masterremotechallenge.database.User
import com.example.masterremotechallenge.database.UserDao
import com.example.masterremotechallenge.database.UserDatabase

class MainViewModel(context: Context): ViewModel() {

    var db: UserDao = UserDatabase.getInstance(context)?.userDao()!!

    private var _loginResult: MutableLiveData<User> = MutableLiveData()
    var loginResult: MutableLiveData<User> = _loginResult

    fun login(email: String, password: String) {
        _loginResult.value = db.findUser(email, password)

        var users = db.getAllUsers()
        Log.d("users", users.toString())
    }
}