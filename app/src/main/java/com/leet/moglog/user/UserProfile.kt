package com.leet.moglog.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.leet.moglog.user.enums.Gender
import java.time.LocalDate
import java.util.UUID

@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey val userId: UUID = UUID.randomUUID(),
    val displayName: String,
    val createdAt: LocalDate = LocalDate.now(),

    val age: Int,
    val heightCm: Int,
    val gender: Gender,

    val activeTrainingProfileId: UUID?,
    val userPreferencesId: UUID?,
)
