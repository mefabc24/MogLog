package com.leet.moglog.workout.templates

import com.leet.moglog.workout.WorkoutPlan

interface WorkoutPlanTemplate {
    fun getPlans(): List<WorkoutPlan>
}