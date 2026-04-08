package com.leet.moglog.exercise

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.exercise.enums.Difficulty

data class Exercise(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String?,
    val videoUrl: String?,
    val muscleTarget: List<MuscleTarget>,
    val difficulty: Difficulty,
    val equipment: Set<Equipment>
) {
    init {
        require(muscleTarget.map(MuscleTarget::muscle).distinct().size == muscleTarget.size) {
            "Exercise '$id' contains duplicate muscle targets."
        }
    }
}
