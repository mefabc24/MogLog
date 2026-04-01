package com.leet.moglog.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.UUID

@Dao
interface UserProfileDao {
    @Insert
    suspend fun insert(userProfile: UserProfile)

    @Update
    suspend fun update(userProfile: UserProfile)

    @Delete
    suspend fun delete(userProfile: UserProfile)

    @Query("SELECT * FROM user_profiles LIMIT 1")
    suspend fun getById(id: UUID): UserProfile?
}