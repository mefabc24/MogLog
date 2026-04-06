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
    fun getPlans(): List<WorkoutPlanTemplate>
}
