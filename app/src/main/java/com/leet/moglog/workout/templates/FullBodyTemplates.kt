package com.leet.moglog.workout.templates

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutExercise
import com.leet.moglog.workout.WorkoutPlanTemplate
import com.leet.moglog.workout.enums.WorkoutSplit

object FullBodyTemplates : WorkoutPlanProvider {
    override fun getPlans(): List<WorkoutPlanTemplate> {
        return listOf(
            beginner(),
            intermediate()
        )
    }

    fun beginner(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.FULL_BODY,
            name = "Beginner Full Body",
            description = "3 day beginner plan",
            workoutDaysPerWeek = 3,
            supportedStyles = setOf(TrainingStyle.BALANCED),
            supportedLevels = setOf(FitnessLevel.BEGINNER),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.CABLE
            ),
            workouts = listOf(
                Workout(
                    name = "Full Body A",
                    exercises = listOf(
                        WorkoutExercise("squat", 3, 8, 90),
                        WorkoutExercise("bench_press", 3, 8, 90),
                        WorkoutExercise("lat_pulldown", 3, 10, 60)
                    )
                ),
                Workout(
                    name = "Full Body B",
                    exercises = listOf(
                        WorkoutExercise("deadlift", 3, 5, 120),
                        WorkoutExercise("overhead_press", 3, 8, 90),
                        WorkoutExercise("seated_row", 3, 10, 60)
                    )
                ),
                Workout(
                    name = "Full Body A",
                    exercises = listOf(
                        WorkoutExercise("squat", 3, 8, 90),
                        WorkoutExercise("bench_press", 3, 8, 90),
                        WorkoutExercise("lat_pulldown", 3, 10, 60)
                    )
                )
            )
        )
    }

    fun intermediate(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.FULL_BODY,
            name = "Intermediate Full Body",
            description = "4 day full body volume plan",
            workoutDaysPerWeek = 4,
            supportedStyles = setOf(TrainingStyle.BALANCED, TrainingStyle.HYPERTROPHY),
            supportedGoals = setOf(PrimaryGoal.HYPERTROPHY, PrimaryGoal.HEALTH),
            supportedLevels = setOf(FitnessLevel.INTERMEDIATE),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.DUMBBELL,
                Equipment.MACHINE
            ),
            workouts = listOf(
                Workout(
                    name = "Full Body Strength",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 4, 6, 120),
                        WorkoutExercise("barbell_bench", 4, 6, 120)
                    )
                ),
                Workout(
                    name = "Full Body Hypertrophy",
                    exercises = listOf(
                        WorkoutExercise("leg_press", 4, 10, 90),
                        WorkoutExercise("incline_dumbbell_press", 4, 10, 90)
                    )
                ),
                Workout(
                    name = "Full Body Strength",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 4, 6, 120),
                        WorkoutExercise("barbell_bench", 4, 6, 120)
                    )
                ),
                Workout(
                    name = "Full Body Hypertrophy",
                    exercises = listOf(
                        WorkoutExercise("leg_press", 4, 10, 90),
                        WorkoutExercise("incline_dumbbell_press", 4, 10, 90)
                    )
                )
            )
        )
    }
}
