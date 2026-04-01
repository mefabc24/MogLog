package com.leet.moglog.exercise

import android.content.Context
import com.leet.moglog.exercise.enums.Difficulty
import com.leet.moglog.exercise.enums.Muscle
import com.leet.moglog.exercise.enums.MuscleGroup
import com.leet.moglog.exercise.enums.MuscleRegion
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExerciseRepository(private val context: Context) {

    // Cached exercises
    val exercises: List<Exercise> by lazy {
        loadExercises(context)
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

    // Utility function to load exercises from JSON file
    fun loadExercises(context: Context): List<Exercise> {
        val json = context.assets.open("exercises.json")
            .bufferedReader()
            .use { it.readText() }

        val type = object : TypeToken<List<Exercise>>() {}.type
        return Gson().fromJson(json, type)
    }
}