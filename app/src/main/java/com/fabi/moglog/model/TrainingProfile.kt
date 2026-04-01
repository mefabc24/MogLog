package com.fabi.moglog.model

import com.fabi.moglog.model.enums.Equipment
import com.fabi.moglog.model.enums.FitnessLevel
import com.fabi.moglog.model.enums.PrimaryGoal
import com.fabi.moglog.model.enums.TrainingLocation
import com.fabi.moglog.model.enums.TrainingStyle

data class TrainingProfile(
    val id: String,
    val profileName: String,
    val primaryGoal: PrimaryGoal,
    val fitnessLevel: FitnessLevel,
    val trainingFrequency: Int,
    val sessionDuration: Int,
    val trainingStyle: TrainingStyle,
    val trainingLocation: TrainingLocation,
    val availableEquipment: List<Equipment>
)
