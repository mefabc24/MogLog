package com.leet.moglog.exercise

import com.leet.moglog.exercise.enums.Difficulty
import com.leet.moglog.exercise.enums.Muscle
import com.leet.moglog.exercise.enums.MuscleGroup
import com.leet.moglog.exercise.enums.MuscleRegion
import com.leet.moglog.helper.TestDataFactory
import com.leet.moglog.infrastructure.json.TestJsonService
import org.junit.Assert.assertEquals
import org.junit.Test

class ExerciseRepositoryTest {
    @Test
    fun getAllExercises() {
        val mockExercises = TestDataFactory.createExercises()

        val jsonService = TestJsonService(mockExercises)
        val repository = ExerciseRepository(jsonService)

        val results: List<Exercise> = repository.getAllExercises()
        val resultNames: List<String> = results.map { it.name }

        assertEquals(mockExercises.map { it.name }, resultNames)
    }

    @Test
    fun getExercisesByMuscleRegion_back() {
        val mockExercises = TestDataFactory.createExercises()

        val jsonService = TestJsonService(mockExercises)
        val repository = ExerciseRepository(jsonService)

        val results: List<Exercise> = repository.getExercisesByMuscleRegion(MuscleRegion.BACK)
        val resultNames: List<String> = results.map { it.name }

        assertEquals(mockExercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle.group.region == MuscleRegion.BACK }
        }.map { it.name }, resultNames)
    }

    @Test
    fun getExercisesByMuscleGroup_chest() {
        val mockExercises = TestDataFactory.createExercises()

        val jsonService = TestJsonService(mockExercises)
        val repository = ExerciseRepository(jsonService)

        val results: List<Exercise> = repository.getExercisesByMuscleGroup(MuscleGroup.CHEST)
        val resultNames: List<String> = results.map { it.name }

        assertEquals(mockExercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle.group == MuscleGroup.CHEST }
        }.map { it.name }, resultNames)
    }

    @Test
    fun getExercisesByMuscle_bicepsLongHead() {
        val mockExercises = TestDataFactory.createExercises()

        val jsonService = TestJsonService(mockExercises)
        val repository = ExerciseRepository(jsonService)

        val results: List<Exercise> = repository.getExercisesByMuscle(Muscle.BICEPS_LONG_HEAD)
        val resultNames: List<String> = results.map { it.name }

        assertEquals(mockExercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle == Muscle.BICEPS_LONG_HEAD }
        }.map { it.name }, resultNames)
    }

    @Test
    fun getExercisesByDifficulty_intermediate() {
        val mockExercises = TestDataFactory.createExercises()

        val jsonService = TestJsonService(mockExercises)
        val repository = ExerciseRepository(jsonService)

        val results: List<Exercise> = repository.getExercisesByDifficulty(Difficulty.INTERMEDIATE)
        val resultNames: List<String> = results.map { it.name }

        assertEquals(mockExercises.filter { exercise ->
            exercise.difficulty == Difficulty.INTERMEDIATE
        }.map { it.name }, resultNames)
    }

    @Test
    fun getExerciseById_existingId() {
        val mockExercises = TestDataFactory.createExercises()

        val jsonService = TestJsonService(mockExercises)
        val repository = ExerciseRepository(jsonService)

        val targetExercise = mockExercises.first()
        val result: Exercise? = repository.getExerciseById(targetExercise.id)

        assertEquals(targetExercise.name, result?.name)
    }
}