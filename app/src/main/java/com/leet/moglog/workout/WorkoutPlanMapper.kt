package com.leet.moglog.workout

import java.util.UUID

fun WorkoutPlanDraft.toWorkoutPlan(trainingProfileId: UUID): WorkoutPlan {
    return WorkoutPlan(
        trainingProfileId = trainingProfileId,
        name = name,
        description = description,
        workoutDaysPerWeek = workoutDaysPerWeek,
        split = split,
        workouts = workouts
    )
}

fun WorkoutPlanTemplate.toWorkoutPlanDraft(): WorkoutPlanDraft {
    return WorkoutPlanDraft(
        name = name,
        description = description,
        workoutDaysPerWeek = workoutDaysPerWeek,
        split = split,
        workouts = workouts
    )
}
