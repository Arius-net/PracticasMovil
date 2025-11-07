package com.sayd.examenpractico.data.repositories

import com.sayd.examenpractico.data.local.db.dao.UserDao
import com.sayd.examenpractico.data.local.db.entity.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    fun getLatestUser(): Flow<User?> = userDao.getLatestUser()

    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers() // Nueva función

    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }
}
