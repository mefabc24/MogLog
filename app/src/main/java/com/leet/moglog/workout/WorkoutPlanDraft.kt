package com.leet.moglog.workout

import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.enums.WorkoutSplit

data class WorkoutPlanDraft(
    val name: String,
    val description: String,
    val workoutDaysPerWeek: Int,
    val split: WorkoutSplit,
    val workouts: List<Workout>
)
