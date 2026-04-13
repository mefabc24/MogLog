package com.leet.moglog.workout

import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.profile.hasLegFocus
import com.leet.moglog.profile.hasLongerSessions
import com.leet.moglog.profile.hasLongSessions
import com.leet.moglog.profile.hasMediumSessions
import com.leet.moglog.profile.hasShortSessions
import com.leet.moglog.profile.hasShorterSessions
import com.leet.moglog.profile.hasStrongArmFocus
import com.leet.moglog.profile.hasUpperFocus
import com.leet.moglog.profile.hasVeryLongSessions
import com.leet.moglog.profile.hasVeryShortSessions
import com.leet.moglog.profile.isAdvanced
import com.leet.moglog.profile.isBeginner
import com.leet.moglog.profile.isHypertrophyFocused
import com.leet.moglog.profile.isIntermediate
import com.leet.moglog.profile.isStrengthFocused
import com.leet.moglog.profile.prefersBalancedFocus
import com.leet.moglog.workout.enums.WorkoutSplit

class WorkoutPlanGenerator(
    private val templateRepository: WorkoutTemplateRepository
) {
    fun generate(profile: TrainingProfile): WorkoutPlanDraft {
        return templateRepository
            .findMatchingTemplates(profile, calculateSplit(profile))
            .firstOrNull()
            ?.toWorkoutPlanDraft(profile.trainingDays)
            ?: generateCustomPlan(profile)
    }

    // Prototype implementation
    private fun generateCustomPlan(profile: TrainingProfile): WorkoutPlanDraft {
        return WorkoutPlanDraft(
            name = "Custom Plan for ${profile.profileName}",
            description = "A custom workout plan generated based on your training profile.",
            workoutDaysPerWeek = profile.trainingFrequency,
            split = calculateSplit(profile),
            scheduledWorkouts = emptyList() // Placeholder, should be generated based on profile
        )
    }


    // Split Calculations --------------------------------------------------------------------------

    private fun calculateSplit(trainingProfile: TrainingProfile): WorkoutSplit {
        val context = trainingProfile.toSplitContext()

        return when (context.trainingFrequency) {
            1 -> WorkoutSplit.FULL_BODY
            2 -> calculateTwoDaySplit(context)
            3 -> calculateThreeDaySplit(context)
            4 -> calculateFourDaySplit(context)
            5 -> calculateFiveDaySplit(context)
            6 -> calculateSixDaySplit(context)
            7 -> calculateSevenDaySplit(context)
            else -> WorkoutSplit.FULL_BODY // Default fallback
        }
    }

    // Split Calculation Helpers -------------------------------------------------------------------
    private fun calculateTwoDaySplit(context: SplitContext): WorkoutSplit = with(context) {
        when {
            isBeginner || hasShorterSessions -> WorkoutSplit.FULL_BODY
            isStrengthFocused -> WorkoutSplit.UPPER_LOWER
            isHypertrophyFocused && hasLongerSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            isHypertrophyFocused -> WorkoutSplit.UPPER_LOWER
            else -> WorkoutSplit.FULL_BODY
        }
    }

    private fun calculateThreeDaySplit(context: SplitContext): WorkoutSplit = with(context) {
        when {
            isBeginner || hasShorterSessions -> WorkoutSplit.FULL_BODY
            isHypertrophyFocused && hasLongerSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            isHypertrophyFocused && hasLongerSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            isHypertrophyFocused -> WorkoutSplit.PUSH_PULL_LEGS
            isStrengthFocused -> WorkoutSplit.UPPER_LOWER
            else -> WorkoutSplit.UPPER_LOWER
        }
    }

    private fun calculateFourDaySplit(context: SplitContext): WorkoutSplit = with(context) {
        when {
            isBeginner || hasShorterSessions || isStrengthFocused -> WorkoutSplit.UPPER_LOWER
            isHypertrophyFocused && hasLongerSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            isHypertrophyFocused && hasLongerSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            isHypertrophyFocused && hasLegFocus -> WorkoutSplit.PUSH_PULL_LEGS
            else -> WorkoutSplit.UPPER_LOWER
        }
    }

    private fun calculateFiveDaySplit(context: SplitContext): WorkoutSplit = with(context) {
        when {
            isBeginner || hasShorterSessions || isStrengthFocused -> WorkoutSplit.UPPER_LOWER
            hasLongerSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            hasLongerSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            hasLegFocus -> WorkoutSplit.PUSH_PULL_LEGS
            isHypertrophyFocused && (isAdvanced || hasVeryLongSessions || prefersBalancedFocus) -> WorkoutSplit.BRO_SPLIT
            isHypertrophyFocused -> WorkoutSplit.PUSH_PULL_LEGS
            else -> WorkoutSplit.UPPER_LOWER
        }
    }

    private fun calculateSixDaySplit(context: SplitContext): WorkoutSplit = with(context) {
        when {
            isBeginner || hasShorterSessions || isStrengthFocused -> WorkoutSplit.UPPER_LOWER
            hasLongerSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            hasLongerSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            isHypertrophyFocused && isAdvanced && hasVeryLongSessions && prefersBalancedFocus -> WorkoutSplit.BRO_SPLIT
            else -> WorkoutSplit.PUSH_PULL_LEGS
        }
    }

    private fun calculateSevenDaySplit(context: SplitContext): WorkoutSplit = with(context) {
        when {
            isBeginner || hasShorterSessions || isStrengthFocused -> WorkoutSplit.UPPER_LOWER
            hasLongerSessions && hasStrongArmFocus -> WorkoutSplit.ARMS_TORSO_LEGS
            hasLongerSessions && hasUpperFocus -> WorkoutSplit.TORSO_LIMB_SPLIT
            hasLegFocus -> WorkoutSplit.PUSH_PULL_LEGS
            isHypertrophyFocused || isAdvanced || prefersBalancedFocus -> WorkoutSplit.BRO_SPLIT
            else -> WorkoutSplit.PUSH_PULL_LEGS
        }
    }
}

// Context class to hold all relevant profile attributes for split calculations
private data class SplitContext(
    val trainingFrequency: Int,
    val isBeginner: Boolean,
    val isIntermediate: Boolean,
    val isAdvanced: Boolean,
    val isStrengthFocused: Boolean,
    val isHypertrophyFocused: Boolean,
    val hasVeryShortSessions: Boolean,
    val hasShortSessions: Boolean,
    val hasMediumSessions: Boolean,
    val hasLongSessions: Boolean,
    val hasVeryLongSessions: Boolean,
    val hasShorterSessions: Boolean,
    val hasLongerSessions: Boolean,
    val hasUpperFocus: Boolean,
    val hasStrongArmFocus: Boolean,
    val hasLegFocus: Boolean,
    val prefersBalancedFocus: Boolean,
)

// Extension function to convert TrainingProfile to SplitContext for easier split calculations
private fun TrainingProfile.toSplitContext(): SplitContext = SplitContext(
    trainingFrequency = trainingFrequency,
    isBeginner = isBeginner(),
    isIntermediate = isIntermediate(),
    isAdvanced = isAdvanced(),
    isStrengthFocused = isStrengthFocused(),
    isHypertrophyFocused = isHypertrophyFocused(),
    hasVeryShortSessions = hasVeryShortSessions(),
    hasShortSessions = hasShortSessions(),
    hasMediumSessions = hasMediumSessions(),
    hasLongSessions = hasLongSessions(),
    hasVeryLongSessions = hasVeryLongSessions(),
    hasShorterSessions = hasShorterSessions(),
    hasLongerSessions = hasLongerSessions(),
    hasUpperFocus = hasUpperFocus(),
    hasStrongArmFocus = hasStrongArmFocus(),
    hasLegFocus = hasLegFocus(),
    prefersBalancedFocus = prefersBalancedFocus(),
)
