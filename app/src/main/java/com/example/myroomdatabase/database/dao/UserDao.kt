package com.example.myroomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myroomdatabase.database.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT COUNT(uid) FROM user")
    suspend fun getTotalItems(): Long

}