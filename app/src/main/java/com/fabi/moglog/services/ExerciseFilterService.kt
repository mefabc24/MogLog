package com.fabi.moglog.services

import com.fabi.moglog.model.Exercise
import com.fabi.moglog.model.enums.Difficulty
import com.fabi.moglog.model.enums.EffectivenessLevel
import com.fabi.moglog.model.enums.Muscle
import com.fabi.moglog.model.enums.MuscleGroup
import com.fabi.moglog.model.enums.MuscleRegion

class ExerciseFilterService {
    fun filterExercises(
        exercises: List<Exercise>,
        nameQuery: String? = null,
        difficulty: Difficulty? = null,
        muscleRegion: MuscleRegion? = null,
        muscleGroup: MuscleGroup? = null,
        muscle: Muscle? = null,
        effectivenessLevel: EffectivenessLevel? = null
    ): List<Exercise> {
        return exercises.filter { exercise ->
            (nameQuery == null || exercise.name.contains(nameQuery, ignoreCase = true)) &&
            (difficulty == null || exercise.difficulty == difficulty) &&
            (muscleRegion == null || exercise.muscleTarget.any { it.muscle.group.region == muscleRegion})  &&
            (muscleGroup == null ||  exercise.muscleTarget.any { it.muscle.group == muscleGroup}) &&
            (muscle == null || exercise.muscleTarget.any { it.muscle == muscle }) &&
            (effectivenessLevel == null || exercise.muscleTarget.any { it.effectivenessLevel == effectivenessLevel })
        }
    }
}