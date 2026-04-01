package com.fabi.moglog.model

import com.fabi.moglog.model.enums.Equipment
import com.fabi.moglog.model.enums.Difficulty

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



