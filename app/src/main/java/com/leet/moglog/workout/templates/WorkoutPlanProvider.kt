package com.leet.moglog.workout.templates

import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutPlanDraft
import com.leet.moglog.workout.enums.WorkoutSplit

interface WorkoutPlanProvider {
    val split: WorkoutSplit

    fun getPlans(): List<WorkoutPlanDraft>

    fun createPlanDraft(
        name: String,
        description: String,
        workoutDaysPerWeek: Int,
        trainingStyle: TrainingStyle,
        primaryGoal: PrimaryGoal? = null,
        fitnessLevel: FitnessLevel? = null,
        trainingLocation: TrainingLocation? = null,
        workouts: List<Workout>
    ): WorkoutPlanDraft {
        return WorkoutPlanDraft(
            name = name,
            description = description,
            split = split,
            workoutDaysPerWeek = workoutDaysPerWeek,
            primaryGoal = primaryGoal,
            fitnessLevel = fitnessLevel,
            trainingLocation = trainingLocation,
            trainingStyle = trainingStyle,
            workouts = workouts
        )
    }
}
