package com.leet.moglog.workout

import java.util.UUID

data class Workout(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val exercises: List<WorkoutExercise>
)
