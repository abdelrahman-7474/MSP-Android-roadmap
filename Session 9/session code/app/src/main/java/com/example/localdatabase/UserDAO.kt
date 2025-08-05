package com.example.localdatabase

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user:User)
}