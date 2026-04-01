package com.fabi.moglog.model

import com.fabi.moglog.model.enums.Gender
import java.time.LocalDate
import java.util.UUID

data class UserProfile(
    val userId: UUID = UUID.randomUUID(),
    val displayName: String,
    val createdAt: LocalDate = LocalDate.now(),

    val age: Int,
    val heightCm: Int,
    val gender: Gender,

    val activeTrainingProfileId: UUID?,
    val userPreferences: UserPreferences,
)
