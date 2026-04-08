package com.leet.moglog.workout

import java.util.UUID

class WorkoutPlanRepository(private val dao: WorkoutPlanDao) {

    // CRUD operations for WorkoutPlan
    suspend fun create(plan: WorkoutPlan) {
        dao.insert(plan)
    }

    suspend fun getById(id: UUID): WorkoutPlan? {
        return dao.getById(id)
    }

    suspend fun getByTrainingProfileId(trainingProfileId: UUID): WorkoutPlan? {
        return dao.getByTrainingProfileId(trainingProfileId)
    }

    suspend fun update(plan: WorkoutPlan) {
        dao.update(plan)
    }

    suspend fun delete(plan: WorkoutPlan) {
        dao.delete(plan)
    }
}