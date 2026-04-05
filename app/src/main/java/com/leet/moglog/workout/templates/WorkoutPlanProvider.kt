package com.leet.moglog.workout.templates

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutPlanTemplate
import com.leet.moglog.workout.enums.WorkoutSplit

interface WorkoutPlanProvider {
    val split: WorkoutSplit

    fun getPlans(): List<WorkoutPlanTemplate>

    fun createTemplate(
        name: String,
        description: String,
        workoutDaysPerWeek: Int,
        supportedStyles: Set<TrainingStyle> = emptySet(),
        supportedGoals: Set<PrimaryGoal> = emptySet(),
        supportedLevels: Set<FitnessLevel> = emptySet(),
        supportedLocations: Set<TrainingLocation> = emptySet(),
        requiredEquipment: Set<Equipment> = emptySet(),
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
}
