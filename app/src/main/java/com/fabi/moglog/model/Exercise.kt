package com.fabi.moglog.model

import com.fabi.moglog.model.enums.Difficulty
import com.fabi.moglog.model.enums.MuscleGroup

data class Exercise(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val videoUrl: String?,
    val muscleTarget: MuscleTarget,
    val difficulty: Difficulty
)



