package com.leet.moglog.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserPreferencesDao {
    @Insert suspend fun insert(userPreferences: UserPreferences)
    @Update suspend fun update(userPreferences: UserPreferences)
    @Delete suspend fun delete(userPreferences: UserPreferences)

    @Query("SELECT * FROM user_preferences LIMIT 1")
    suspend fun getAll(): UserPreferences?
}