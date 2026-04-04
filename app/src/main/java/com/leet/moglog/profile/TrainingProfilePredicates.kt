package com.leet.moglog.profile

import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingFocus
import com.leet.moglog.profile.enums.TrainingStyle

fun TrainingProfile.isBeginner(): Boolean = fitnessLevel == FitnessLevel.BEGINNER

fun TrainingProfile.isAdvanced(): Boolean = fitnessLevel == FitnessLevel.ADVANCED

fun TrainingProfile.hasShortSessions(): Boolean = sessionDuration < 45

fun TrainingProfile.hasLongSessions(): Boolean = sessionDuration >= 60

fun TrainingProfile.hasVeryLongSessions(): Boolean = sessionDuration >= 75

fun TrainingProfile.hasStrongArmFocus(): Boolean = trainingFocus == TrainingFocus.ARMS

fun TrainingProfile.hasLegFocus(): Boolean = trainingFocus == TrainingFocus.LEGS

fun TrainingProfile.isHypertrophyFocused(): Boolean {
    return primaryGoal == PrimaryGoal.HYPERTROPHY || trainingStyle == TrainingStyle.HYPERTROPHY
}

fun TrainingProfile.isStrengthFocused(): Boolean {
    return primaryGoal == PrimaryGoal.STRENGTH || trainingStyle == TrainingStyle.STRENGTH_POWER
}

fun TrainingProfile.hasUpperFocus(): Boolean {
    return trainingFocus == TrainingFocus.UPPER_BODY || trainingFocus == TrainingFocus.ARMS
}

fun TrainingProfile.prefersBalancedFocus(): Boolean {
    return trainingFocus == TrainingFocus.BALANCED || trainingFocus == TrainingFocus.FULL_BODY
}
