package com.leet.moglog.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "user_preferences")
data class UserPreferences(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val notifications: Boolean
    // Add more user preference fields as needed
)