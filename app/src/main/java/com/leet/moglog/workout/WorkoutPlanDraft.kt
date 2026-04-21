package com.leet.moglog.workout

import com.leet.moglog.workout.enums.WorkoutSplit

data class WorkoutPlanDraft(
    val name: String,
    val description: String,
    val workoutDaysPerWeek: Int,
    val split: WorkoutSplit,
    val scheduledWorkouts: List<ScheduledWorkout>
)
