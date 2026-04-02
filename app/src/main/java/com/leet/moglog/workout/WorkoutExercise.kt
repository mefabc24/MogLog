package com.leet.moglog.workout

data class WorkoutExercise(
    val exerciseId: String,
    val sets: Int,
    val reps: Int,
    val restTimeSeconds: Int,
) {
    val repScheme: String
        get() = "${sets}x${reps}"
}
