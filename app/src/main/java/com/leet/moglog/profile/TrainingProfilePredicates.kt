package com.leet.moglog.profile

import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.SessionLength
import com.leet.moglog.profile.enums.TrainingFocus
import com.leet.moglog.profile.enums.TrainingStyle

fun TrainingProfile.isBeginner(): Boolean = fitnessLevel == FitnessLevel.BEGINNER
fun TrainingProfile.isIntermediate(): Boolean = fitnessLevel == FitnessLevel.INTERMEDIATE
fun TrainingProfile.isAdvanced(): Boolean = fitnessLevel == FitnessLevel.ADVANCED

fun TrainingProfile.hasVeryShortSessions(): Boolean = mapToSessionLength(sessionDuration) == SessionLength.VERY_SHORT
fun TrainingProfile.hasShortSessions(): Boolean = mapToSessionLength(sessionDuration) == SessionLength.SHORT
fun TrainingProfile.hasMediumSessions(): Boolean = mapToSessionLength(sessionDuration) == SessionLength.MEDIUM
fun TrainingProfile.hasLongSessions(): Boolean = mapToSessionLength(sessionDuration) == SessionLength.LONG
fun TrainingProfile.hasVeryLongSessions(): Boolean = mapToSessionLength(sessionDuration) == SessionLength.VERY_LONG

fun TrainingProfile.hasShorterSessions(): Boolean =
    mapToSessionLength(sessionDuration) == SessionLength.SHORT || mapToSessionLength(sessionDuration) == SessionLength.VERY_SHORT

fun TrainingProfile.hasLongerSessions(): Boolean =
    mapToSessionLength(sessionDuration) == SessionLength.VERY_LONG || mapToSessionLength(sessionDuration) == SessionLength.LONG

fun TrainingProfile.hasStrongArmFocus(): Boolean = trainingFocus == TrainingFocus.ARMS
fun TrainingProfile.hasLegFocus(): Boolean = trainingFocus == TrainingFocus.LEGS

fun TrainingProfile.isHypertrophyFocused(): Boolean =
    primaryGoal == PrimaryGoal.HYPERTROPHY || trainingStyle == TrainingStyle.HYPERTROPHY

fun TrainingProfile.isStrengthFocused(): Boolean =
    primaryGoal == PrimaryGoal.STRENGTH || trainingStyle == TrainingStyle.STRENGTH_POWER

fun TrainingProfile.hasUpperFocus(): Boolean =
    trainingFocus == TrainingFocus.UPPER_BODY || trainingFocus == TrainingFocus.ARMS

fun TrainingProfile.prefersBalancedFocus(): Boolean =
    trainingFocus == TrainingFocus.BALANCED || trainingFocus == TrainingFocus.FULL_BODY


// Helper function to map session duration to SessionLength
private fun mapToSessionLength(duration: Int): SessionLength {
    return when {
        duration < 30 -> SessionLength.VERY_SHORT
        duration in 30..44 -> SessionLength.SHORT
        duration in 45..59 -> SessionLength.MEDIUM
        duration in 60..74 -> SessionLength.LONG
        else -> SessionLength.VERY_LONG
    }
}
