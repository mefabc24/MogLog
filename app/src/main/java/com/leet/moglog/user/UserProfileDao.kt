package com.leet.moglog.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import java.util.UUID

@Dao
interface UserProfileDao {
    @Insert suspend fun insert(userProfile: UserProfile)
    @Update suspend fun update(userProfile: UserProfile)
    @Delete suspend fun delete(userProfile: UserProfile)

    @Query("SELECT * FROM user_profiles WHERE userId = :id")
    suspend fun getById(id: UUID): UserProfile?

    @Transaction
    @Query("SELECT * FROM user_profiles WHERE userId = :id")
    suspend fun getWithRelations(id: UUID): UserProfileWithRelations?

    @Query("UPDATE user_profiles SET activeTrainingProfileId = :trainingProfileId WHERE userId = :userId")
    suspend fun updateActiveTrainingProfile(userId: UUID, trainingProfileId: UUID?)
}