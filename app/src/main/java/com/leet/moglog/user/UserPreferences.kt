package com.leet.moglog.user

import androidx.room.Entity

@Entity(tableName = "user_preferences")
data class UserPreferences(
    val notifications: Boolean
    // Add more user preference fields as needed
)