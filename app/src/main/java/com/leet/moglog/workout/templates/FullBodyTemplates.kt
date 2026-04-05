package com.leet.moglog.workout.templates

import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutExercise
import com.leet.moglog.workout.WorkoutPlanDraft
import com.leet.moglog.workout.enums.WorkoutSplit

object FullBodyTemplates : WorkoutPlanTemplate {
    override fun getPlans(): List<WorkoutPlanDraft> {
        return listOf(
            beginner(),
            intermediate()
        )
    }

    fun beginner(): WorkoutPlanDraft {
        return createPlan(
            name = "Beginner Full Body",
            description = "3 day beginner plan",
            workoutDaysPerWeek = 3,
            trainingStyle = TrainingStyle.BALANCED,
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

    fun intermediate(): WorkoutPlanDraft {
        return createPlan(
            name = "Intermediate Full Body",
            description = "4 day full body volume plan",
            workoutDaysPerWeek = 4,
            trainingStyle = TrainingStyle.BALANCED,
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
    ): WorkoutPlanDraft {
        return WorkoutPlanDraft(
            name = name,
            description = description,
            split = WorkoutSplit.FULL_BODY,
            workoutDaysPerWeek = workoutDaysPerWeek,
            primaryGoal = primaryGoal,
            fitnessLevel = fitnessLevel,
            trainingLocation = trainingLocation,
            trainingStyle = trainingStyle,
            workouts = workouts
        )
    }
}
