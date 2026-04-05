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
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.UUID

class WorkoutTemplateRepositoryTest {

    private val repository = WorkoutTemplateRepository()

    @Test
    fun findMatchingTemplates_returnsBroSplitTemplate_forFiveDayHypertrophyProfile() {
        val matches = repository.findMatchingTemplates(
            profile(
                trainingFrequency = 5,
                trainingStyle = TrainingStyle.HYPERTROPHY
            ),
            WorkoutSplit.BRO_SPLIT
        )

        assertEquals(1, matches.size)
        assertEquals("Classic Bro Split", matches.first().name)
    }

    @Test
    fun findMatchingTemplates_returnsEmptyList_whenNoTemplateMatchesSplitAndStyle() {
        val matches = repository.findMatchingTemplates(
            profile(
                trainingFrequency = 5,
                trainingStyle = TrainingStyle.BALANCED
            ),
            WorkoutSplit.BRO_SPLIT
        )

        assertTrue(matches.isEmpty())
    }

    @Test
    fun explore_findMatchingTemplates_printsMatchesToConsole() {
        findAndPrintMatches(
            profile(
                trainingFrequency = 6,
                trainingStyle = TrainingStyle.BALANCED,
                trainingFocus = TrainingFocus.UPPER_BODY,
                fitnessLevel = FitnessLevel.INTERMEDIATE
            ),
            WorkoutSplit.TORSO_LIMB_SPLIT
        )
    }

    private fun findAndPrintMatches(
        profile: TrainingProfile,
        split: WorkoutSplit
    ): List<WorkoutPlanDraft> {
        val matches = repository.findMatchingTemplates(profile, split)

        println("Profile: days=${profile.trainingFrequency}, style=${profile.trainingStyle}, goal=${profile.primaryGoal}, level=${profile.fitnessLevel}, location=${profile.trainingLocation}, focus=${profile.trainingFocus}")
        println("Requested split: $split")

        if (matches.isEmpty()) {
            println("No matching templates found.")
            return matches
        }

        matches.forEachIndexed { index, plan ->
            println("[${index + 1}] ${plan.name} | ${plan.description}")
            println("    days=${plan.workoutDaysPerWeek}, style=${plan.trainingStyle}, workouts=${plan.workouts.size}")
            plan.workouts.forEach { workout ->
                val exercises = workout.exercises.joinToString(", ") { it.exerciseId }
                println("    - ${workout.name}: $exercises")
            }
        }

        return matches
    }

    private fun profile(
        trainingFrequency: Int,
        trainingStyle: TrainingStyle,
        primaryGoal: PrimaryGoal = PrimaryGoal.HYPERTROPHY,
        fitnessLevel: FitnessLevel = FitnessLevel.INTERMEDIATE,
        trainingFocus: TrainingFocus = TrainingFocus.BALANCED,
        trainingLocation: TrainingLocation = TrainingLocation.GYM
    ): TrainingProfile {
        return TrainingProfile(
            userId = UUID.randomUUID(),
            profileName = "Template Repository Test Profile",
            primaryGoal = primaryGoal,
            fitnessLevel = fitnessLevel,
            trainingFrequency = trainingFrequency,
            sessionDuration = 75,
            trainingStyle = trainingStyle,
            trainingLocation = trainingLocation,
            trainingFocus = trainingFocus,
            availableEquipment = listOf(
                Equipment.BARBELL,
                Equipment.DUMBBELL,
                Equipment.BENCH,
                Equipment.CABLE
            )
        )
    }
}
