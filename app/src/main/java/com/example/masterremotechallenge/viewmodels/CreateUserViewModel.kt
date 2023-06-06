package com.example.masterremotechallenge.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.masterremotechallenge.database.User
import com.example.masterremotechallenge.database.UserDao
import com.example.masterremotechallenge.database.UserDatabase

class CreateUserViewModel(context: Context): ViewModel() {

    private var _createUserResult: MutableLiveData<User> = MutableLiveData()
    var createUserResult: MutableLiveData<User> = _createUserResult

    var db: UserDao = UserDatabase.getInstance(context)?.userDao()!!

    fun createUser(user: User) {
        db.createUser(user)
        val newUser = db.findUser(user.email, user.password)
        newUser.let {
            _createUserResult.value = newUser
        }
    }
}