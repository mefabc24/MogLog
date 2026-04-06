package com.leet.moglog.workout.templates

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutPlanTemplate
import com.leet.moglog.workout.enums.WorkoutSplit

// Wrapper function
fun <T> supportsAll(): Set<T> = emptySet()

fun createTemplate(
    split: WorkoutSplit,
    name: String,
    description: String,
    workoutDaysPerWeek: Int,
    supportedStyles: Set<TrainingStyle> = supportsAll(),
    supportedGoals: Set<PrimaryGoal> = supportsAll(),
    supportedLevels: Set<FitnessLevel> = supportsAll(),
    supportedLocations: Set<TrainingLocation> = supportsAll(),
    requiredEquipment: Set<Equipment> = supportsAll(),
    workouts: List<Workout>
): WorkoutPlanTemplate {
    return WorkoutPlanTemplate(
        name = name,
        description = description,
        split = split,
        workoutDaysPerWeek = workoutDaysPerWeek,
        supportedStyles = supportedStyles,
        supportedGoals = supportedGoals,
        supportedLevels = supportedLevels,
        supportedLocations = supportedLocations,
        requiredEquipment = requiredEquipment,
        workouts = workouts
    )
}