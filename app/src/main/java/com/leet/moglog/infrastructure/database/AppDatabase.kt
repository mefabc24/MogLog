package com.leet.moglog.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.profile.TrainingProfileDao
import com.leet.moglog.infrastructure.database.converter.CommonConverters
import com.leet.moglog.infrastructure.database.converter.CollectionConverters
import com.leet.moglog.infrastructure.database.converter.EnumConverters
import com.leet.moglog.user.UserPreferences
import com.leet.moglog.user.UserPreferencesDao
import com.leet.moglog.user.UserProfile
import com.leet.moglog.user.UserProfileDao
import com.leet.moglog.workout.WorkoutPlan
import com.leet.moglog.workout.WorkoutPlanDao

@Database(
    entities = [
        TrainingProfile::class,
        UserProfile::class,
        UserPreferences::class,
        WorkoutPlan::class
    ],
    version = 1
)

@TypeConverters(
    EnumConverters::class,
    CollectionConverters::class,
    CommonConverters::class
)

abstract class AppDatabase : RoomDatabase() {
    // DAOs
    abstract fun trainingProfileDao(): TrainingProfileDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun userPreferencesDao(): UserPreferencesDao
    abstract fun workoutPlanDao(): WorkoutPlanDao
}
