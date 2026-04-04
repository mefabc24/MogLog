package com.leet.moglog.user

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "user_preferences",
    foreignKeys = [
        ForeignKey(
            entity = UserProfile::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["userId"], unique = true)]
)
data class UserPreferences(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    val notifications: Boolean
    // Add more user preference fields as needed
)