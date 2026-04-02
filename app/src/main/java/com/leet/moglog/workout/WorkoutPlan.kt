package com.leet.moglog.workout

import java.util.UUID

data class WorkoutPlan(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val workouts: List<Workout>
)
