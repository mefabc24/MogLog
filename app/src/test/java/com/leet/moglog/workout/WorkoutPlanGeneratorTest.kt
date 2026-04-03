package com.leet.moglog.workout

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingFocus
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.enums.WorkoutSplit
import org.junit.Assert.assertEquals
import org.junit.Test

class WorkoutPlanGeneratorTest {

    private val generator = WorkoutPlanGenerator(WorkoutTemplateRepository())

    @Test
    fun generate_returnsUpperLower_forTwoDayStrengthProfile() {
        val plan = generator.generate(
            profile(
                trainingFrequency = 2,
                sessionDuration = 75,
                primaryGoal = PrimaryGoal.STRENGTH,
                trainingStyle = TrainingStyle.STRENGTH_POWER
            )
        )

        assertEquals(WorkoutSplit.UPPER_LOWER, plan.split)
    }

    @Test
    fun generate_returnsUpperLower_forFourDayBeginnerProfile() {
        val plan = generator.generate(
            profile(
                trainingFrequency = 4,
                sessionDuration = 50,
                fitnessLevel = FitnessLevel.BEGINNER,
                trainingStyle = TrainingStyle.BALANCED
            )
        )

        assertEquals(WorkoutSplit.UPPER_LOWER, plan.split)
    }

    @Test
    fun generate_returnsBroSplit_forFiveDayAdvancedHypertrophyProfile() {
        val plan = generator.generate(
            profile(
                trainingFrequency = 5,
                sessionDuration = 75,
                fitnessLevel = FitnessLevel.ADVANCED,
                trainingStyle = TrainingStyle.HYPERTROPHY,
                trainingFocus = TrainingFocus.BALANCED
            )
        )

        assertEquals(WorkoutSplit.BRO_SPLIT, plan.split)
    }

    @Test
    fun generate_returnsTorsoLimb_forSixDayUpperFocusProfile() {
        val plan = generator.generate(
            profile(
                trainingFrequency = 6,
                sessionDuration = 75,
                trainingStyle = TrainingStyle.HYPERTROPHY,
                trainingFocus = TrainingFocus.UPPER_BODY
            )
        )

        assertEquals(WorkoutSplit.TORSO_LIMB_SPLIT, plan.split)
    }

    @Test
    fun generate_returnsBroSplit_forSevenDayAdvancedHypertrophyProfile() {
        val plan = generator.generate(
            profile(
                trainingFrequency = 7,
                sessionDuration = 75,
                fitnessLevel = FitnessLevel.ADVANCED,
                trainingStyle = TrainingStyle.HYPERTROPHY,
                trainingFocus = TrainingFocus.FULL_BODY
            )
        )

        assertEquals(WorkoutSplit.BRO_SPLIT, plan.split)
    }

    private fun profile(
        trainingFrequency: Int,
        sessionDuration: Int,
        primaryGoal: PrimaryGoal = PrimaryGoal.HYPERTROPHY,
        fitnessLevel: FitnessLevel = FitnessLevel.INTERMEDIATE,
        trainingStyle: TrainingStyle = TrainingStyle.HYPERTROPHY,
        trainingFocus: TrainingFocus = TrainingFocus.BALANCED
    ): TrainingProfile {
        return TrainingProfile(
            profileName = "Test Profile",
            primaryGoal = primaryGoal,
            fitnessLevel = fitnessLevel,
            trainingFrequency = trainingFrequency,
            sessionDuration = sessionDuration,
            trainingStyle = trainingStyle,
            trainingLocation = TrainingLocation.GYM,
            trainingFocus = trainingFocus,
            availableEquipment = listOf(Equipment.BARBELL, Equipment.DUMBBELL)
        )
    }
}
