package com.leet.moglog.workout.templates

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutExercise
import com.leet.moglog.workout.WorkoutPlanTemplate
import com.leet.moglog.workout.enums.WorkoutSplit

object UpperLowerTemplates : WorkoutPlanProvider {
    override fun getPlans(): List<WorkoutPlanTemplate> {
        return listOf(
            standard(),
            strengthFocused()
        )
    }

    fun standard(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.UPPER_LOWER,
            name = "Upper Lower Standard",
            description = "4 day split",
            workoutDaysPerWeek = 4,
            supportedStyles = setOf(TrainingStyle.BALANCED, TrainingStyle.HYPERTROPHY),
            supportedGoals = setOf(
                PrimaryGoal.HYPERTROPHY,
                PrimaryGoal.HEALTH,
                PrimaryGoal.WEIGHT_LOSS
            ),
            supportedLevels = setOf(FitnessLevel.BEGINNER, FitnessLevel.INTERMEDIATE),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH
            ),
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

    fun strengthFocused(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.UPPER_LOWER,
            name = "Upper Lower Strength",
            description = "2 Day Heavy compound focused split",
            workoutDaysPerWeek = 2,
            supportedStyles = setOf(TrainingStyle.STRENGTH_POWER),
            supportedGoals = setOf(PrimaryGoal.STRENGTH),
            supportedLevels = setOf(FitnessLevel.INTERMEDIATE, FitnessLevel.ADVANCED),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.RACK,
                Equipment.PULLUP_BAR
            ),
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
}
