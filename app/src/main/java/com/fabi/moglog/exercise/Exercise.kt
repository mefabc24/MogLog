package com.fabi.moglog.exercise

import com.fabi.moglog.common.enums.Equipment
import com.fabi.moglog.exercise.enums.Difficulty

data class Exercise(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val videoUrl: String?,
    val muscleTarget: List<MuscleTarget>,
    val difficulty: Difficulty,
    val equipment: List<Equipment>
)



