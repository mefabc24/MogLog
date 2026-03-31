package com.fabi.moglog.model

import com.fabi.moglog.model.enums.EffectivenessLevel
import com.fabi.moglog.model.enums.MuscleGroup

data class MuscleTarget(
    val MuscleGroup: MuscleGroup,
    val effectivenessLevel: EffectivenessLevel
)