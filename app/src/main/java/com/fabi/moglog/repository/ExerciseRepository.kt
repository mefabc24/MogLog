package com.fabi.moglog.repository

import android.content.Context
import com.fabi.moglog.model.Exercise
import com.fabi.moglog.model.enums.Difficulty
import com.fabi.moglog.model.enums.Muscle
import com.fabi.moglog.model.enums.MuscleGroup
import com.fabi.moglog.model.enums.MuscleRegion
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExerciseRepository(private val context: Context) {

    // Cached exercises
    val exercises: List<Exercise> by lazy {
        loadExercises(context)
    }

    // Basic query operations
    fun getExercisesByMuscleRegion(muscleRegion: MuscleRegion): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle.group.region == muscleRegion }
        }
    }

    fun getExercisesByMuscleGroup(muscleGroup: MuscleGroup): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle.group == muscleGroup }
        }
    }

    fun getExercisesByMuscle(muscle: Muscle): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle == muscle }
        }
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

    fun getExercisesByMuscleRegionAndDifficulty(muscleRegion: MuscleRegion, difficulty: Difficulty): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle.group.region == muscleRegion && exercise.difficulty == difficulty }
        }
    }

    fun getExercisesByMuscleGroupAndDifficulty(muscleGroup: MuscleGroup, difficulty: Difficulty): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle.group == muscleGroup && exercise.difficulty == difficulty }
        }
    }

    fun getExercisesByMuscleAndDifficulty(muscle: Muscle, difficulty: Difficulty): List<Exercise> {
        return exercises.filter { exercise ->
            exercise.muscleTarget.any { it.muscle == muscle && exercise.difficulty == difficulty }
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