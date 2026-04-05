package com.leet.moglog.workout.templates

import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutExercise
import com.leet.moglog.workout.WorkoutPlanTemplate
import com.leet.moglog.workout.enums.WorkoutSplit

object BroSplitTemplates : WorkoutPlanProvider {
    override val split = WorkoutSplit.BRO_SPLIT

    override fun getPlans(): List<WorkoutPlanTemplate> {
        return listOf(
            classicFiveDay(),
            volumeSixDay(),
            advancedSevenDay()
        )
    }

    fun classicFiveDay(): WorkoutPlanTemplate {
        return createTemplate(
            name = "Classic Bro Split",
            description = "5 day bodybuilding split with one major body part per session",
            workoutDaysPerWeek = 5,
            supportedStyles = setOf(TrainingStyle.HYPERTROPHY),
            workouts = listOf(
                Workout(
                    name = "Chest",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 4, 8, 90),
                        WorkoutExercise("incline_dumbbell_press", 4, 10, 75),
                        WorkoutExercise("push_up", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Back",
                    exercises = listOf(
                        WorkoutExercise("pull_up", 4, 8, 90),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("seated_cable_row", 3, 10, 60),
                        WorkoutExercise("shrug", 3, 12, 45)
                    )
                ),
                Workout(
                    name = "Legs",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 4, 8, 120),
                        WorkoutExercise("romanian_deadlift", 4, 8, 90),
                        WorkoutExercise("leg_press", 3, 12, 75),
                        WorkoutExercise("calf_raise", 4, 15, 45)
                    )
                ),
                Workout(
                    name = "Shoulders",
                    exercises = listOf(
                        WorkoutExercise("overhead_press", 4, 8, 90),
                        WorkoutExercise("lateral_raise", 4, 15, 45),
                        WorkoutExercise("rear_delt_fly", 3, 15, 45),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Arms",
                    exercises = listOf(
                        WorkoutExercise("barbell_curl", 4, 10, 60),
                        WorkoutExercise("hammer_curl", 3, 12, 45),
                        WorkoutExercise("skull_crusher", 4, 10, 60),
                        WorkoutExercise("triceps_pushdown", 3, 12, 45)
                    )
                )
            )
        )
    }

    fun volumeSixDay(): WorkoutPlanTemplate {
        return createTemplate(
            name = "Volume Bro Split",
            description = "6 day bodybuilding split with an added delts and arms pump day",
            workoutDaysPerWeek = 6,
            supportedStyles = setOf(TrainingStyle.HYPERTROPHY),
            workouts = listOf(
                Workout(
                    name = "Chest",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 4, 8, 90),
                        WorkoutExercise("incline_dumbbell_press", 4, 10, 75),
                        WorkoutExercise("push_up", 3, 20, 45)
                    )
                ),
                Workout(
                    name = "Back",
                    exercises = listOf(
                        WorkoutExercise("pull_up", 4, 8, 90),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("lat_pulldown", 3, 12, 60),
                        WorkoutExercise("hyperextension", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Legs",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 4, 8, 120),
                        WorkoutExercise("leg_press", 4, 10, 90),
                        WorkoutExercise("leg_curl", 3, 12, 60),
                        WorkoutExercise("seated_calf_raise", 4, 15, 45)
                    )
                ),
                Workout(
                    name = "Shoulders",
                    exercises = listOf(
                        WorkoutExercise("overhead_press", 4, 8, 90),
                        WorkoutExercise("lateral_raise", 4, 12, 45),
                        WorkoutExercise("rear_delt_fly", 4, 15, 45),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Arms",
                    exercises = listOf(
                        WorkoutExercise("barbell_curl", 4, 10, 60),
                        WorkoutExercise("hammer_curl", 4, 12, 45),
                        WorkoutExercise("skull_crusher", 4, 10, 60),
                        WorkoutExercise("triceps_pushdown", 4, 12, 45)
                    )
                ),
                Workout(
                    name = "Delts and Arms Pump",
                    exercises = listOf(
                        WorkoutExercise("lateral_raise", 4, 15, 45),
                        WorkoutExercise("rear_delt_fly", 3, 15, 45),
                        WorkoutExercise("hammer_curl", 3, 15, 45),
                        WorkoutExercise("triceps_pushdown", 3, 15, 45),
                        WorkoutExercise("russian_twist", 3, 20, 30)
                    )
                )
            )
        )
    }

    fun advancedSevenDay(): WorkoutPlanTemplate {
        return createTemplate(
            name = "Advanced Bro Split",
            description = "7 day advanced split with extra pump work for recovery-friendly volume",
            workoutDaysPerWeek = 7,
            supportedStyles = setOf(TrainingStyle.HYPERTROPHY),
            workouts = listOf(
                Workout(
                    name = "Chest Strength",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 5, 6, 120),
                        WorkoutExercise("incline_dumbbell_press", 4, 8, 90),
                        WorkoutExercise("push_up", 3, 20, 45)
                    )
                ),
                Workout(
                    name = "Back Strength",
                    exercises = listOf(
                        WorkoutExercise("pull_up", 5, 6, 120),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("seated_cable_row", 3, 10, 60),
                        WorkoutExercise("shrug", 3, 12, 45)
                    )
                ),
                Workout(
                    name = "Legs Strength",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 5, 6, 120),
                        WorkoutExercise("romanian_deadlift", 4, 8, 90),
                        WorkoutExercise("leg_press", 3, 12, 75),
                        WorkoutExercise("calf_raise", 4, 15, 45)
                    )
                ),
                Workout(
                    name = "Shoulders",
                    exercises = listOf(
                        WorkoutExercise("overhead_press", 4, 8, 90),
                        WorkoutExercise("lateral_raise", 4, 15, 45),
                        WorkoutExercise("rear_delt_fly", 4, 15, 45),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Arms",
                    exercises = listOf(
                        WorkoutExercise("barbell_curl", 4, 10, 60),
                        WorkoutExercise("hammer_curl", 4, 12, 45),
                        WorkoutExercise("skull_crusher", 4, 10, 60),
                        WorkoutExercise("triceps_pushdown", 4, 12, 45)
                    )
                ),
                Workout(
                    name = "Chest and Back Pump",
                    exercises = listOf(
                        WorkoutExercise("incline_dumbbell_press", 3, 12, 60),
                        WorkoutExercise("lat_pulldown", 3, 12, 60),
                        WorkoutExercise("seated_cable_row", 3, 12, 60),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Legs and Core Pump",
                    exercises = listOf(
                        WorkoutExercise("walking_lunge", 3, 14, 60),
                        WorkoutExercise("leg_extension", 3, 15, 45),
                        WorkoutExercise("leg_curl", 3, 15, 45),
                        WorkoutExercise("seated_calf_raise", 4, 15, 45),
                        WorkoutExercise("crunch", 3, 20, 30)
                    )
                )
            )
        )
    }
}
