package com.example.lostfound.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun getListUser(): List<User>

    @Delete
    fun deleteUser(user: User)
}