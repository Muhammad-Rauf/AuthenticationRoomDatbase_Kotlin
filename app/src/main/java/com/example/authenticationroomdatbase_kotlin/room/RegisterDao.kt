package com.example.authenticationroomdatbase_kotlin.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface RegisterDao {
    @Insert
    suspend fun insert(register: RegisterEntity)


    @Query("SELECT * FROM Register_users_table WHERE user_email LIKE :email LIMIT 1")
  fun searchEamil(email: String): RegisterEntity



//@Query("SELECT * FROM Register_users_table WHERE user_email LIKE :email AND passwrd LIKE :password")
//fun search(email: String, password: String): RegisterDatabase



    @Query("SELECT * FROM Register_users_table ORDER BY user_email DESC")
    fun getAllUsers(): LiveData<List<RegisterEntity>>



}