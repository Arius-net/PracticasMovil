package com.sayd.examenpractico.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sayd.examenpractico.data.local.db.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users ORDER BY id DESC LIMIT 1")
    fun getLatestUser(): Flow<User?>

    @Query("SELECT * FROM users ORDER BY id DESC") // Nueva función
    fun getAllUsers(): Flow<List<User>>
}
