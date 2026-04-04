package com.leet.moglog.user

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.user.enums.Gender
import java.time.LocalDate
import java.util.UUID

@Entity(
    tableName = "user_profiles",
    foreignKeys  = [
        ForeignKey(
            entity = TrainingProfile::class,
            parentColumns = ["id"],
            childColumns = ["activeTrainingProfileId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("activeTrainingProfileId")
    ]
)
data class UserProfile(
    @PrimaryKey val userId: UUID = UUID.randomUUID(),
    val displayName: String,
    val createdAt: LocalDate = LocalDate.now(),

    val age: Int,
    val heightCm: Int,
    val gender: Gender,

    val activeTrainingProfileId: UUID?
)
