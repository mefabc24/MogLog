package com.leet.moglog.workout

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.enums.WorkoutSplit

data class WorkoutPlanTemplate(
    val name: String,
    val description: String,
    val workoutDaysPerWeek: Int,
    val split: WorkoutSplit,
    val supportedStyles: Set<TrainingStyle> = emptySet(),
    val supportedGoals: Set<PrimaryGoal> = emptySet(),
    val supportedLevels: Set<FitnessLevel> = emptySet(),
    val supportedLocations: Set<TrainingLocation> = emptySet(),
    val requiredEquipment: Set<Equipment> = emptySet(),
    val workouts: List<Workout>
)
