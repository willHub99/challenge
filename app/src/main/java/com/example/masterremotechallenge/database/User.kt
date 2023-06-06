package com.example.masterremotechallenge.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "email")
    val email:String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "isLogged")
    val isLogged: Boolean = false,
)
