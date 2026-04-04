package com.leet.moglog.user

import androidx.room.Embedded
import androidx.room.Relation
import com.leet.moglog.profile.TrainingProfile

data class UserProfileWithRelations(
    @Embedded val userProfile: UserProfile,

    @Relation(
        parentColumn = "activeTrainingProfileId",
        entityColumn = "id"
    )
    val activeTrainingProfile: TrainingProfile?,

    @Relation(
        parentColumn = "userPreferencesId",
        entityColumn = "id"
    )
    val userPreferences: UserPreferences?
)
