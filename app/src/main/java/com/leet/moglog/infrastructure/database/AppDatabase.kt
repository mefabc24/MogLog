package com.leet.moglog.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leet.moglog.fitness.TrainingProfile
import com.leet.moglog.fitness.TrainingProfileDao
import com.leet.moglog.user.UserPreferencesDao
import com.leet.moglog.user.UserProfileDao

@Database(
    entities = [
        TrainingProfile::class
    ],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {
    // DAOs
    abstract fun trainingProfileDao(): TrainingProfileDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun userPreferencesDao(): UserPreferencesDao
}