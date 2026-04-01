package com.leet.moglog.exercise

import android.content.Context
import com.leet.moglog.exercise.enums.Difficulty
import com.leet.moglog.exercise.enums.Muscle
import com.leet.moglog.exercise.enums.MuscleGroup
import com.leet.moglog.exercise.enums.MuscleRegion
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leet.moglog.infrastructure.json.JsonLoader

private const val EXERCISE_DATA_FILE: String = "exercises.json"

class ExerciseRepository(private val jsonLoader: JsonLoader) {

    // Cached exercises
    val exercises: List<Exercise> by lazy {
        val type = object : TypeToken<List<Exercise>>() {}.type
        jsonLoader.loadFromAssets(EXERCISE_DATA_FILE, type)
    }

    // Basic query operations
    @Suppress("unused")
    fun getExercisesByMuscleRegion(muscleRegion: MuscleRegion): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle.group.region == muscleRegion }
        }
    }

    @Suppress("unused")
    fun getExercisesByMuscleGroup(muscleGroup: MuscleGroup): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle.group == muscleGroup }
        }
    }

    @Suppress("unused")
    fun getExercisesByMuscle(muscle: Muscle): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle == muscle }
        }
    }

    @Suppress("unused")
    fun getExercisesByDifficulty(difficulty: Difficulty): List<Exercise> {
        return exercises.filter { it.difficulty == difficulty }
    }

    @Suppress("unused")
    fun getExerciseById(id: String): Exercise? {
        return exercises.find { it.id == id }
    }

    @Suppress("unused")
    fun getAllExercises(): List<Exercise> {
        return exercises
    }
}