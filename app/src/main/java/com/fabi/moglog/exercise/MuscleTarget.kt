package com.fabi.moglog.exercise

import com.fabi.moglog.exercise.enums.EffectivenessLevel
import com.fabi.moglog.exercise.enums.Muscle

data class MuscleTarget(
    val muscle: Muscle,
    val effectivenessLevel: EffectivenessLevel
)