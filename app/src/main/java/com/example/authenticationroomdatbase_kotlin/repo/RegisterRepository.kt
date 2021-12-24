package com.example.authenticationroomdatbase_kotlin.repo
import androidx.lifecycle.LiveData
import com.example.authenticationroomdatbase_kotlin.room.RegisterDao
import com.example.authenticationroomdatbase_kotlin.room.RegisterEntity

class RegisterRepository(private val dao: RegisterDao) {

    val getAllUsers: LiveData<List<RegisterEntity>> = dao.getAllUsers()


    suspend fun addUser(user: RegisterEntity) {
        dao.insert(user)
    }

   // suspend fun searchByEmail(email: String,password:String ) = dao.search(email,password)
    suspend fun searchByEmail(email: String ) = dao.searchEamil(email)



}