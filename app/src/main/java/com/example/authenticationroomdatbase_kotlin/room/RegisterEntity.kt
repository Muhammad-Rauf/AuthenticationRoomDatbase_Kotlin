package com.example.authenticationroomdatbase_kotlin.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Register_users_table")
data class RegisterEntity(

    @PrimaryKey
    var user_email: String,

    var firstName: String,

    var lastName: String,

    var passwrd: String
)