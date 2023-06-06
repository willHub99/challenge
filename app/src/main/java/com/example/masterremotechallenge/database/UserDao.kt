package com.example.masterremotechallenge.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE email LIKE :email AND password LIKE :password")
    fun findUser(email: String, password: String): User

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Insert
    fun createUser(user: User)

    @Delete
    fun deleteUser(user: User)

}