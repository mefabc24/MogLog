package com.fabi.moglog.model

import com.fabi.moglog.model.enums.EffectivenessLevel
import com.fabi.moglog.model.enums.Muscle

data class MuscleTarget(
    val muscle: Muscle,
    val effectivenessLevel: EffectivenessLevel
)