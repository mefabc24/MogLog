package com.leet.moglog.profile

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.UUID

@Dao
interface TrainingProfileDao {
    @Insert
    suspend fun insert(trainingProfile: TrainingProfile)

    @Update
    suspend fun update(trainingProfile: TrainingProfile)

    @Delete
    suspend fun delete(trainingProfile: TrainingProfile)

    @Query("SELECT * FROM training_profiles")
    suspend fun getAll(): List<TrainingProfile>

    @Query("SELECT * FROM training_profiles WHERE id = :id")
    suspend fun getById(id: UUID): TrainingProfile?
}