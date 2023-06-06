package com.example.masterremotechallenge.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.masterremotechallenge.database.User
import com.example.masterremotechallenge.database.UserDao
import com.example.masterremotechallenge.database.UserDatabase

class ListUserViewModel(context: Context): ViewModel() {

    private var _getAllUsersResult: MutableLiveData<List<User>> = MutableLiveData()
    var getAllUsersResult: MutableLiveData<List<User>> = _getAllUsersResult

    var db: UserDao = UserDatabase.getInstance(context)?.userDao()!!

    fun getAllUser() {
        _getAllUsersResult.value = db.getAllUsers()
    }

    fun deleteUser(user: User) {
        db.deleteUser(user)
        this.getAllUser()
    }

}