package com.leet.moglog.workout

import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.enums.WorkoutSplit
import java.util.UUID

data class WorkoutPlan(
    val id: UUID = UUID.randomUUID(),
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
