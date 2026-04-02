package com.leet.moglog.workout

import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.workout.templates.FullBodyTemplates
import com.leet.moglog.workout.templates.PushPullLegsTemplates
import com.leet.moglog.workout.templates.UpperLowerTemplates
import com.leet.moglog.workout.templates.WorkoutPlanTemplate

class WorkoutTemplateRepository {

    private val sources: List<WorkoutPlanTemplate> = listOf(
        FullBodyTemplates,
        UpperLowerTemplates,
        PushPullLegsTemplates
    )

    fun getAllTemplates(): List<WorkoutPlan> = sources.flatMap { it.getPlans() }

    fun findMatchingTemplates(profile: TrainingProfile) {
        // TODO: Implement logic to filter templates based on profile attributes like fitness level, goals, etc.
    }
}