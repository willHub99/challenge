package com.example.masterremotechallenge.utils

import com.example.masterremotechallenge.database.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun User.toJson(): String {
    return Json.encodeToString(this)
}

fun String.fromJson(): User {
    return Json.decodeFromString(this)
}