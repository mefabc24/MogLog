package com.leet.moglog.onboarding

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.TrainingProfile
import com.leet.moglog.profile.TrainingProfileRepository
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingFocus
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.user.UserProfile
import com.leet.moglog.user.UserProfileRepository
import com.leet.moglog.user.enums.Gender
import com.leet.moglog.workout.WorkoutPlanGenerator
import com.leet.moglog.workout.WorkoutPlanRepository
import java.util.UUID

class OnboardingService(
    private val userProfileRepository: UserProfileRepository,
    private val trainingProfileRepository: TrainingProfileRepository,
    private val workoutPlanRepository: WorkoutPlanRepository,
    private val workoutPlanGenerator: WorkoutPlanGenerator
) {
    suspend fun createUserProfile(
        displayName: String,
        age: Int,
        heightCm: Int,
        gender: Gender
    ): UserProfile {
        val user = UserProfile(
            displayName = displayName,
            age = age,
            heightCm = heightCm,
            gender = gender)

        userProfileRepository.create(user)
        return user
    }

    suspend fun completeOnboarding(
        userId: UUID,
        profileName: String,
        primaryGoal: PrimaryGoal,
        fitnessLevel: FitnessLevel,
        trainingFrequency: Int,
        sessionDuration: Int,
        trainingStyle: TrainingStyle,
        trainingLocation: TrainingLocation,
        trainingFocus: TrainingFocus,
        availableEquipment: List<Equipment>
        ) {


        // Create training profile
        val trainingProfile = createTrainingProfile(
            userId,
            profileName,
            primaryGoal,
            fitnessLevel,
            trainingFrequency,
            sessionDuration,
            trainingStyle,
            trainingLocation,
            trainingFocus,
            availableEquipment
        )

        // Set active training profile for the user
        userProfileRepository.setActiveTrainingProfile(userId, trainingProfile.id)

        // Generate initial workout plan based on the training profile
        val workoutPlan = workoutPlanGenerator.generate(trainingProfile)

        // Save the generated workout plan
        workoutPlanRepository.create(workoutPlan)
    }


    private suspend fun createTrainingProfile(
        userId: UUID,
        profileName: String,
        primaryGoal: PrimaryGoal,
        fitnessLevel: FitnessLevel,
        trainingFrequency: Int,
        sessionDuration: Int,
        trainingStyle: TrainingStyle,
        trainingLocation: TrainingLocation,
        trainingFocus: TrainingFocus,
        availableEquipment: List<Equipment>
    ): TrainingProfile {
        val trainingProfile = TrainingProfile(
            userId = userId,
            profileName = profileName,
            primaryGoal = primaryGoal,
            fitnessLevel = fitnessLevel,
            trainingFrequency = trainingFrequency,
            sessionDuration = sessionDuration,
            trainingStyle = trainingStyle,
            trainingLocation = trainingLocation,
            trainingFocus = trainingFocus,
            availableEquipment = availableEquipment
        )
        trainingProfileRepository.create(trainingProfile)
        return trainingProfile
    }
}