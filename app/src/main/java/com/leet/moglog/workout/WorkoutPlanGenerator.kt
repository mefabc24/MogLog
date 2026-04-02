package com.leet.moglog.workout

import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.workout.enums.WorkoutSplit

class WorkoutPlanGenerator {
    // TODO: Implement workout plan generation logic based on training profile

    // Utility function to calculate workout split based on training profile
    fun calculateSplit(trainingProfile: TrainingProfile): WorkoutSplit {
        // Basic logic to determine workout split based on training profile
        return when (trainingProfile.trainingFrequency) {
            1 -> WorkoutSplit.FULL_BODY
            2 -> WorkoutSplit.UPPER_LOWER
            in 3..6 -> WorkoutSplit.PUSH_PULL_LEGS
            7 -> WorkoutSplit.BRO_SPLIT
            else -> WorkoutSplit.FULL_BODY // Fallback, should not happen due to validation
        }
    }
}
