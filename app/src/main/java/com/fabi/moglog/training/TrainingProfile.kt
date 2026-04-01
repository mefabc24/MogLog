package com.fabi.moglog.training

import com.fabi.moglog.common.enums.Equipment
import com.fabi.moglog.training.enums.FitnessLevel
import com.fabi.moglog.training.enums.PrimaryGoal
import com.fabi.moglog.training.enums.TrainingLocation
import com.fabi.moglog.training.enums.TrainingStyle
import java.util.UUID

data class TrainingProfile(
    val id: UUID = UUID.randomUUID(),
    val profileName: String,
    val primaryGoal: PrimaryGoal,
    val fitnessLevel: FitnessLevel,
    val trainingFrequency: Int,
    val sessionDuration: Int,
    val trainingStyle: TrainingStyle,
    val trainingLocation: TrainingLocation,
    val availableEquipment: List<Equipment>
)