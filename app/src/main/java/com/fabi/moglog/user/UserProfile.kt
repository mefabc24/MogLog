package com.fabi.moglog.user

import com.fabi.moglog.user.enums.Gender
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
