package com.example.authenticationroomdatbase_kotlin.mvm

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.authenticationroomdatbase_kotlin.repo.RegisterRepository
import com.example.authenticationroomdatbase_kotlin.room.RegisterDatabase
import com.example.authenticationroomdatbase_kotlin.room.RegisterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) :AndroidViewModel(application){

    val getAllUsers: LiveData<List<RegisterEntity>>
    val repository: RegisterRepository
    init {
        val dao = RegisterDatabase.getDatabase(application).userDao()
        repository = RegisterRepository(dao)
        getAllUsers = repository.getAllUsers
    }

    fun addUser(user: RegisterEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }


    suspend fun search(email:String) = repository.searchByEmail(email)
//        viewModelScope.launch(Dispatchers.IO) {
//        }
}