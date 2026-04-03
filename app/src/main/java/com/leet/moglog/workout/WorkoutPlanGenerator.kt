package com.leet.moglog.workout

import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.profile.hasLegFocus
import com.leet.moglog.profile.hasLongSessions
import com.leet.moglog.profile.hasShortSessions
import com.leet.moglog.profile.hasStrongArmFocus
import com.leet.moglog.profile.hasUpperFocus
import com.leet.moglog.profile.hasVeryLongSessions
import com.leet.moglog.profile.isAdvanced
import com.leet.moglog.profile.isBeginner
import com.leet.moglog.profile.isHypertrophyFocused
import com.leet.moglog.profile.isStrengthFocused
import com.leet.moglog.profile.prefersBalancedFocus
import com.leet.moglog.workout.enums.WorkoutSplit

class WorkoutPlanGenerator(
    private val templateRepository: WorkoutTemplateRepository
) {
    fun generate(profile: TrainingProfile): WorkoutPlan {
        return templateRepository
            .findMatchingTemplates(profile, calculateSplit(profile))
            .firstOrNull()
            ?: generateCustomPlan(profile)
    }

    // Prototype implementation
    private fun generateCustomPlan(profile: TrainingProfile): WorkoutPlan {
        return WorkoutPlan(
            name = "Custom Plan for ${profile.profileName}",
            description = "A custom workout plan generated based on your training profile.",
            workoutDaysPerWeek = profile.trainingFrequency,
            split = calculateSplit(profile),
            trainingStyle = profile.trainingStyle,
            primaryGoal = profile.primaryGoal,
            fitnessLevel = profile.fitnessLevel,
            trainingLocation = profile.trainingLocation,
            workouts = emptyList() // Placeholder, should be generated based on profile
        )
    }


    // Split Calculations --------------------------------------------------------------------------

    private fun calculateSplit(trainingProfile: TrainingProfile): WorkoutSplit {
        return when (trainingProfile.trainingFrequency) {
            1 -> WorkoutSplit.FULL_BODY
            2 -> calculateTwoDaySplit(trainingProfile)
            3 -> calculateThreeDaySplit(trainingProfile)
            4 -> calculateFourDaySplit(trainingProfile)
            5 -> calculateFiveDaySplit(trainingProfile)
            6 -> calculateSixDaySplit(trainingProfile)
            7 -> calculateSevenDaySplit(trainingProfile)
            else -> WorkoutSplit.FULL_BODY // Default fallback
        }
    }

    // Split Calculation Helpers -------------------------------------------------------------------
    private fun calculateTwoDaySplit(profile: TrainingProfile): WorkoutSplit {
        val isBeginner = profile.isBeginner()
        val hasShortSessions = profile.hasShortSessions()
        val isHypertrophy = profile.isHypertrophyFocused()
        val isStrength = profile.isStrengthFocused()
        val hasLongSessions = profile.hasLongSessions()
        val hasUpperFocus = profile.hasUpperFocus()

        return when {
            isBeginner || hasShortSessions -> WorkoutSplit.FULL_BODY
            isStrength -> WorkoutSplit.UPPER_LOWER
            isHypertrophy && hasLongSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            isHypertrophy -> WorkoutSplit.UPPER_LOWER
            else -> WorkoutSplit.FULL_BODY
        }
    }

    private fun calculateThreeDaySplit(profile: TrainingProfile): WorkoutSplit {
        val isBeginner = profile.isBeginner()
        val hasShortSessions = profile.hasShortSessions()
        val isHypertrophy = profile.isHypertrophyFocused()
        val hasLongSessions = profile.hasLongSessions()
        val hasUpperFocus = profile.hasUpperFocus()
        val hasStrongArmFocus = profile.hasStrongArmFocus()
        val isStrength = profile.isStrengthFocused()

        return when {
            isBeginner || hasShortSessions -> WorkoutSplit.FULL_BODY
            isHypertrophy && hasLongSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            isHypertrophy && hasLongSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            isHypertrophy -> WorkoutSplit.PUSH_PULL_LEGS
            isStrength -> WorkoutSplit.UPPER_LOWER
            else -> WorkoutSplit.UPPER_LOWER
        }
    }

    private fun calculateFourDaySplit(profile: TrainingProfile): WorkoutSplit {
        val isBeginner = profile.isBeginner()
        val hasShortSessions = profile.hasShortSessions()
        val isStrength = profile.isStrengthFocused()
        val isHypertrophy = profile.isHypertrophyFocused()
        val hasLongSessions = profile.hasLongSessions()
        val hasUpperFocus = profile.hasUpperFocus()
        val hasStrongArmFocus = profile.hasStrongArmFocus()
        val hasLegFocus = profile.hasLegFocus()

        return when {
            isBeginner || hasShortSessions || isStrength -> WorkoutSplit.UPPER_LOWER
            isHypertrophy && hasLongSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            isHypertrophy && hasLongSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            isHypertrophy && hasLegFocus -> WorkoutSplit.PUSH_PULL_LEGS
            else -> WorkoutSplit.UPPER_LOWER
        }
    }

    private fun calculateFiveDaySplit(profile: TrainingProfile): WorkoutSplit {
        val isBeginner = profile.isBeginner()
        val hasShortSessions = profile.hasShortSessions()
        val isStrength = profile.isStrengthFocused()
        val isHypertrophy = profile.isHypertrophyFocused()
        val hasLongSessions = profile.hasLongSessions()
        val hasUpperFocus = profile.hasUpperFocus()
        val hasStrongArmFocus = profile.hasStrongArmFocus()
        val hasLegFocus = profile.hasLegFocus()
        val isAdvanced = profile.isAdvanced()
        val hasVeryLongSessions = profile.hasVeryLongSessions()
        val prefersBalancedFocus = profile.prefersBalancedFocus()

        return when {
            isBeginner || hasShortSessions || isStrength -> WorkoutSplit.UPPER_LOWER
            hasLongSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            hasLongSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            hasLegFocus -> WorkoutSplit.PUSH_PULL_LEGS
            isHypertrophy && (isAdvanced || hasVeryLongSessions || prefersBalancedFocus) -> WorkoutSplit.BRO_SPLIT
            isHypertrophy -> WorkoutSplit.PUSH_PULL_LEGS
            else -> WorkoutSplit.UPPER_LOWER
        }
    }

    private fun calculateSixDaySplit(profile: TrainingProfile): WorkoutSplit {
        val isBeginner = profile.isBeginner()
        val hasShortSessions = profile.hasShortSessions()
        val isStrength = profile.isStrengthFocused()
        val hasLongSessions = profile.hasLongSessions()
        val hasVeryLongSessions = profile.hasVeryLongSessions()
        val hasUpperFocus = profile.hasUpperFocus()
        val hasStrongArmFocus = profile.hasStrongArmFocus()
        val isAdvanced = profile.isAdvanced()
        val isHypertrophy = profile.isHypertrophyFocused()
        val prefersBalancedFocus = profile.prefersBalancedFocus()

        return when {
            isBeginner || hasShortSessions || isStrength -> WorkoutSplit.UPPER_LOWER
            hasLongSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            hasLongSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            isHypertrophy && isAdvanced && hasVeryLongSessions && prefersBalancedFocus -> WorkoutSplit.BRO_SPLIT
            else -> WorkoutSplit.PUSH_PULL_LEGS
        }
    }

    private fun calculateSevenDaySplit(profile: TrainingProfile): WorkoutSplit {
        val isBeginner = profile.isBeginner()
        val hasShortSessions = profile.hasShortSessions()
        val isStrength = profile.isStrengthFocused()
        val hasLongSessions = profile.hasLongSessions()
        val hasUpperFocus = profile.hasUpperFocus()
        val hasStrongArmFocus = profile.hasStrongArmFocus()
        val hasLegFocus = profile.hasLegFocus()
        val prefersBalancedFocus = profile.prefersBalancedFocus()
        val isAdvanced = profile.isAdvanced()
        val isHypertrophy = profile.isHypertrophyFocused()

        return when {
            isBeginner || hasShortSessions || isStrength -> WorkoutSplit.UPPER_LOWER
            hasLongSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            hasLongSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            hasLegFocus -> WorkoutSplit.PUSH_PULL_LEGS
            isHypertrophy || isAdvanced || prefersBalancedFocus -> WorkoutSplit.BRO_SPLIT
            else -> WorkoutSplit.PUSH_PULL_LEGS
        }
    }
}
