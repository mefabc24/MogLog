package com.leet.moglog.workout

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.workout.enums.WorkoutSplit
import java.util.UUID

@Entity(
    tableName = "workout_plans",
    foreignKeys = [
        ForeignKey(
            entity = TrainingProfile::class,
            parentColumns = ["id"],
            childColumns = ["trainingProfileId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["trainingProfileId"], unique = true)]
)
data class WorkoutPlan(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val trainingProfileId: UUID,
    val name: String,
    val description: String,
    val workoutDaysPerWeek: Int,
    val split: WorkoutSplit,
    @ColumnInfo(name = "workouts")
    val scheduledWorkouts: List<ScheduledWorkout>
)
