package com.leet.moglog.workout

import java.time.DayOfWeek
import java.util.UUID

fun WorkoutPlanDraft.toWorkoutPlan(trainingProfileId: UUID): WorkoutPlan {
    return WorkoutPlan(
        trainingProfileId = trainingProfileId,
        name = name,
        description = description,
        workoutDaysPerWeek = workoutDaysPerWeek,
        split = split,
        scheduledWorkouts = scheduledWorkouts
    )
}

fun WorkoutPlanTemplate.toWorkoutPlanDraft(trainingDays: Set<DayOfWeek>): WorkoutPlanDraft {
    val orderedTrainingDays = trainingDays.sortedBy { it.value }
    require(orderedTrainingDays.size == workouts.size) {
        "Training days count must match template workouts count."
    }

    return WorkoutPlanDraft(
        name = name,
        description = description,
        workoutDaysPerWeek = workoutDaysPerWeek,
        split = split,
        scheduledWorkouts = orderedTrainingDays.zip(workouts) { day, workout ->
            ScheduledWorkout(day = day, workout = workout)
        }
    )
}
