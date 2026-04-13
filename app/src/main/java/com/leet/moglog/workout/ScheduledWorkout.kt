package com.leet.moglog.workout

import java.time.DayOfWeek

data class ScheduledWorkout(
    val day: DayOfWeek,
    val workout: Workout
)
