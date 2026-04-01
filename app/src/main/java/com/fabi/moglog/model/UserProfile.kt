package com.fabi.moglog.model

import com.fabi.moglog.model.enums.Gender
import java.util.Date
import java.util.UUID

data class UserProfile(
    val userId: UUID,
    val displayName: Gender,
    val createdAt: Date,

    val age: Int,
    val heightCm: Int,
    val gender: String,

    val trainingProfile: TrainingProfile,
    val userPreferences: UserPreferences,
)
