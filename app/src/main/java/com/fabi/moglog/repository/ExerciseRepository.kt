package com.fabi.moglog.repository

import android.content.Context
import com.fabi.moglog.model.Exercise
import com.fabi.moglog.model.enums.Difficulty
import com.fabi.moglog.model.enums.MuscleGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExerciseRepository(private val context: Context) {

    // Cached exercises
    val exercises: List<Exercise> by lazy {
        loadExercises(context)
    }

    // Basic query operations
    fun getExercisesByMuscleGroup(muscleGroup: MuscleGroup): List<Exercise> {
        return exercises.filter { it.muscleGroup == muscleGroup }
    }

    fun getExercisesByDifficulty(difficulty: Difficulty): List<Exercise> {
        return exercises.filter { it.difficulty == difficulty }
    }

    fun getExerciseById(id: String): Exercise? {
        return exercises.find { it.id == id }
    }

    fun getAllExercises(): List<Exercise> {
        return exercises
    }

    fun getExercisesByMuscleGroupAndDifficulty(muscleGroup: String, difficulty: String): List<Exercise> {
        return exercises.filter {
            it.muscleGroup.name.equals(muscleGroup, ignoreCase = true) &&
            it.difficulty.name.equals(difficulty, ignoreCase = true)
        }
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