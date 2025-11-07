package com.sayd.examenpractico.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sayd.examenpractico.data.local.db.dao.UserDao
import com.sayd.examenpractico.data.local.db.entity.User

@Database(entities = [User::class], version = 2, exportSchema = false) // Versión incrementada a 2
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
