package com.leet.moglog.workout.templates

import com.leet.moglog.workout.WorkoutPlanDraft

interface WorkoutPlanTemplate {
    fun getPlans(): List<WorkoutPlanDraft>
}
