package com.leet.moglog.workout

import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.workout.enums.WorkoutSplit
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

    fun findMatchingTemplates(
        profile: TrainingProfile,
        split: WorkoutSplit
    ): List<WorkoutPlan> =
        getAllTemplates().filter { plan ->
            plan.workoutDaysPerWeek == profile.trainingFrequency &&
            plan.split == split &&
            plan.trainingStyle == profile.trainingStyle &&
            (plan.primaryGoal == null || plan.primaryGoal == profile.primaryGoal) &&
            (plan.fitnessLevel == null || plan.fitnessLevel == profile.fitnessLevel) &&
            (plan.trainingLocation == null || plan.trainingLocation == profile.trainingLocation)
        }
}