package com.leet.moglog.workout.templates

import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutExercise
import com.leet.moglog.workout.WorkoutPlan
import com.leet.moglog.workout.enums.WorkoutSplit

object UpperLowerTemplates {

    fun standard(): WorkoutPlan {
        return createPlan(
            name = "Upper Lower Standard",
            description = "4 day split",
            workoutDaysPerWeek = 4,
            trainingStyle = TrainingStyle.BALANCED,
            workouts = listOf(
                Workout(
                    name = "Upper",
                    exercises = listOf(
                        WorkoutExercise("bench_press", 4, 8, 90),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("shoulder_press", 3, 10, 60)
                    )
                ),
                Workout(
                    name = "Lower",
                    exercises = listOf(
                        WorkoutExercise("squat", 4, 8, 120),
                        WorkoutExercise("romanian_deadlift", 3, 10, 90),
                        WorkoutExercise("calf_raise", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Upper",
                    exercises = listOf(
                        WorkoutExercise("bench_press", 4, 8, 90),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("shoulder_press", 3, 10, 60)
                    )
                ),
                Workout(
                    name = "Lower",
                    exercises = listOf(
                        WorkoutExercise("squat", 4, 8, 120),
                        WorkoutExercise("romanian_deadlift", 3, 10, 90),
                        WorkoutExercise("calf_raise", 3, 15, 45)
                    )
                )
            )
        )
    }

    fun strengthFocused(): WorkoutPlan {
        return createPlan(
            name = "Upper Lower Strength",
            description = "2 Day Heavy compound focused split",
            workoutDaysPerWeek = 2,
            trainingStyle = TrainingStyle.STRENGTH_POWER,
            workouts = listOf(
                Workout(
                    name = "Upper Strength",
                    exercises = listOf(
                        WorkoutExercise("bench_press", 5, 5, 120),
                        WorkoutExercise("weighted_pullup", 5, 5, 120)
                    )
                ),
                Workout(
                    name = "Lower Strength",
                    exercises = listOf(
                        WorkoutExercise("back_squat", 5, 5, 120),
                        WorkoutExercise("deadlift", 5, 3, 150)
                    )
                )
            )
        )
    }

    // Helper function
    private fun createPlan(
        name: String,
        description: String,
        workoutDaysPerWeek: Int,
        trainingStyle: TrainingStyle,
        primaryGoal: PrimaryGoal? = null,
        fitnessLevel: FitnessLevel? = null,
        trainingLocation: TrainingLocation? = null,
        workouts: List<Workout>
    ): WorkoutPlan {
        return WorkoutPlan(
            name = name,
            description = description,
            split = WorkoutSplit.UPPER_LOWER,
            workoutDaysPerWeek = workoutDaysPerWeek,
            primaryGoal = primaryGoal,
            fitnessLevel = fitnessLevel,
            trainingLocation = trainingLocation,
            trainingStyle = trainingStyle,
            workouts = workouts
        )
    }
}