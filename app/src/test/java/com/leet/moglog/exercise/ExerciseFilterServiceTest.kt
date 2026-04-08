package com.leet.moglog.exercise

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.exercise.enums.EffectivenessLevel
import com.leet.moglog.exercise.enums.Muscle
import com.leet.moglog.helper.TestDataFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class ExerciseFilterServiceTest {
    private val service = ExerciseFilterService()

    @Test
    fun filterExercises_requiresEffectivenessOnSameMuscleTarget() {
        val benchPress = TestDataFactory.createExercises().first { it.id == "bench_press" }

        val results = service.filterExercises(
            exercises = listOf(benchPress),
            muscle = Muscle.TRICEPS_LONG_HEAD,
            effectivenessLevel = EffectivenessLevel.HIGH
        )

        assertEquals(emptyList<Exercise>(), results)
    }

    @Test
    fun filterExercises_matchesWhenSingleMuscleTargetSatisfiesAllFilters() {
        val benchPress = TestDataFactory.createExercises().first { it.id == "bench_press" }

        val results = service.filterExercises(
            exercises = listOf(benchPress),
            muscle = Muscle.PECTORALIS_MAJOR_STERNAL,
            effectivenessLevel = EffectivenessLevel.HIGH
        )

        assertEquals(listOf(benchPress), results)
    }

    @Test
    fun filterExercises_supportsAdditionalExerciseFieldFilters() {
        val benchPress = TestDataFactory.createExercises()
            .first { it.id == "bench_press" }
            .copy(
                imageUrl = "https://example.com/bench.png",
                videoUrl = "https://example.com/bench.mp4"
            )
        val pushUp = TestDataFactory.createExercises().first { it.id == "push_up" }

        val results = service.filterExercises(
            exercises = listOf(benchPress, pushUp),
            idQuery = "bench",
            descriptionQuery = "compound",
            requiredEquipment = setOf(Equipment.BARBELL, Equipment.BENCH),
            hasImage = true,
            hasVideo = true
        )

        assertEquals(listOf(benchPress), results)
    }
}
