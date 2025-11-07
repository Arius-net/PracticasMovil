package com.sayd.examenpractico.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.sayd.examenpractico.data.local.db.AppDatabase
import com.sayd.examenpractico.data.local.db.entity.User
import com.sayd.examenpractico.data.repositories.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository

    init {
        val db = Room.databaseBuilder(
            application,
            AppDatabase::class.java, "app_database"
        ).fallbackToDestructiveMigration()
         .allowMainThreadQueries().build()
        userRepository = UserRepository(db.userDao())
    }

    val latestUser = userRepository.getLatestUser()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    val allUsers = userRepository.getAllUsers()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun saveUser(name: String, password: String) {
        viewModelScope.launch {
            if (name.isNotBlank() && password.isNotBlank()) {
                userRepository.insertUser(User(name = name, password = password))
            }
        }
    }
}
