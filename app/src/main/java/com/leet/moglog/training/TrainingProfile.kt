package com.leet.moglog.training

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.training.enums.FitnessLevel
import com.leet.moglog.training.enums.PrimaryGoal
import com.leet.moglog.training.enums.TrainingLocation
import com.leet.moglog.training.enums.TrainingStyle
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