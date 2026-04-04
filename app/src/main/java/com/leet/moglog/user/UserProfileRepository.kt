package com.leet.moglog.user

import java.util.UUID

class UserProfileRepository(
    val dao: UserProfileDao
) {

    // CRUD operations for UserProfile
    suspend fun create(profile: UserProfile) {
        dao.insert(profile)
    }

    suspend fun getById(id: UUID): UserProfile? {
        return dao.getById(id)
    }

    suspend fun getWithRelations(id: UUID): UserProfileWithRelations? {
        return dao.getWithRelations(id)
    }

    suspend fun update(profile: UserProfile) {
        dao.update(profile)
    }

    suspend fun delete(profile: UserProfile) {
        dao.delete(profile)
    }

    // Set active training profile for a user
    suspend fun setActiveTrainingProfile(userId: UUID, trainingProfileId: UUID?) {
        dao.updateActiveTrainingProfile(userId, trainingProfileId)
    }
}