package com.leet.moglog.profile

import java.util.UUID

class TrainingProfileRepository(val dao: TrainingProfileDao) {

    // CRUD operations for TrainingProfile
    suspend fun create(profile: TrainingProfile) {
        dao.insert(profile)
    }

    suspend fun getAll(): List<TrainingProfile> {
        return dao.getAll()
    }

    suspend fun getById(id: UUID): TrainingProfile? {
        return dao.getById(id)
    }

    suspend fun update(profile: TrainingProfile) {
        dao.update(profile)
    }

    suspend fun delete(profile: TrainingProfile) {
        dao.delete(profile)
    }
}