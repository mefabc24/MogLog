package com.leet.moglog.onboarding

import com.leet.moglog.profile.TrainingProfileRepository
import com.leet.moglog.user.UserProfileRepository
import com.leet.moglog.workout.WorkoutPlanGenerator
import com.leet.moglog.workout.WorkoutPlanRepository

class OnboardingService(
    private val userProfileRepository: UserProfileRepository,
    private val trainingProfileRepository: TrainingProfileRepository,
    private val workoutPlanRepository: WorkoutPlanRepository,
    private val workoutPlanGenerator: WorkoutPlanGenerator
) {
    // TODO - Implement onboarding logic, such as creating user profiles, training profiles, and generating initial workout plans based on user input.
}