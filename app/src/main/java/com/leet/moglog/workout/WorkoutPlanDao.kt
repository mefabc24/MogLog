package com.leet.moglog.workout

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.UUID

@Dao
interface WorkoutPlanDao {
    @Insert suspend fun insert(workoutPlan: WorkoutPlan)
    @Update suspend fun update(workoutPlan: WorkoutPlan)
    @Delete suspend fun delete(workoutPlan: WorkoutPlan)

    @Query("SELECT * FROM workout_plans WHERE id = :id")
    suspend fun getById(id: UUID): WorkoutPlan?

    @Query("SELECT * FROM workout_plans WHERE trainingProfileId = :trainingProfileId LIMIT 1")
    suspend fun getByTrainingProfileId(trainingProfileId: UUID): WorkoutPlan?
}