package com.leet.moglog.workout

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
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
    indices = [Index("trainingProfileId")]
)
data class WorkoutPlan(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val trainingProfileId: UUID,
    val name: String,
    val description: String,
    val workoutDaysPerWeek: Int,
    val split: WorkoutSplit,
    val trainingStyle: TrainingStyle,
    val primaryGoal: PrimaryGoal? = null,
    val fitnessLevel: FitnessLevel? = null,
    val trainingLocation: TrainingLocation? = null,
    val workouts: List<Workout>
)
