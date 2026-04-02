package com.leet.moglog.profile

class TrainingProfileRepository(val dao: TrainingProfileDao) {

    // CRUD operations for TrainingProfile
    suspend fun createProfile(profile: TrainingProfile) {
        dao.insert(profile)
    }

    suspend fun getAllProfiles(): List<TrainingProfile> {
        return dao.getAll()
    }

    suspend fun updateProfile(profile: TrainingProfile) {
        dao.update(profile)
    }

    suspend fun deleteProfile(profile: TrainingProfile) {
        dao.delete(profile)
    }
}