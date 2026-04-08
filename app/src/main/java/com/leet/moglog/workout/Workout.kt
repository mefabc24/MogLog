package com.leet.moglog.workout

import java.util.UUID

data class Workout(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String? = null,
    val exercises: List<WorkoutExercise>
)
