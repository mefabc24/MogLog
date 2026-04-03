package com.leet.moglog.profile

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingFocus
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import java.util.UUID

@Entity(tableName = "training_profiles")
data class TrainingProfile(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val profileName: String,
    val primaryGoal: PrimaryGoal,
    val fitnessLevel: FitnessLevel,
    val trainingFrequency: Int,
    val sessionDuration: Int,
    val trainingStyle: TrainingStyle,
    val trainingLocation: TrainingLocation,
    val trainingFocus: TrainingFocus,
    val availableEquipment: List<Equipment>
)