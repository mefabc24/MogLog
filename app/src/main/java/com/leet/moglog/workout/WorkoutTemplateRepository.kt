package com.leet.moglog.workout

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.workout.enums.WorkoutSplit
import com.leet.moglog.workout.templates.ArmsTorsoLegsTemplates
import com.leet.moglog.workout.templates.BroSplitTemplates
import com.leet.moglog.workout.templates.FullBodyTemplates
import com.leet.moglog.workout.templates.PushPullLegsTemplates
import com.leet.moglog.workout.templates.TorsoLimbsTemplates
import com.leet.moglog.workout.templates.UpperLowerTemplates
import com.leet.moglog.workout.templates.WorkoutPlanProvider

class WorkoutTemplateRepository {
    private val sources: List<WorkoutPlanProvider> = listOf(
        FullBodyTemplates,
        UpperLowerTemplates,
        PushPullLegsTemplates,
        BroSplitTemplates,
        TorsoLimbsTemplates,
        ArmsTorsoLegsTemplates
    )

    fun getAllTemplates(): List<WorkoutPlanTemplate> = sources.flatMap { it.getPlans() }

    fun findMatchingTemplates(
        profile: TrainingProfile,
        split: WorkoutSplit
    ): List<WorkoutPlanTemplate> =
        getAllTemplates().filter { template ->
            template.workoutDaysPerWeek == profile.trainingFrequency &&
            template.split == split &&
            template.supportedStyles.matches(profile.trainingStyle) &&
            template.supportedGoals.matches(profile.primaryGoal) &&
            template.supportedLevels.matches(profile.fitnessLevel) &&
            template.supportedLocations.matches(profile.trainingLocation) &&
            template.requiredEquipment.matchesAvailable(profile.availableEquipment)
        }
}

private fun <T> Set<T>.matches(value: T): Boolean = isEmpty() || contains(value)

private fun Set<Equipment>.matchesAvailable(
    availableEquipment: Collection<Equipment>
): Boolean =
    isEmpty() || availableEquipment.containsAll(this)
