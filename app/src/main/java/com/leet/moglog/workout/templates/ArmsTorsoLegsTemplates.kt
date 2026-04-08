package com.leet.moglog.workout.templates

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutExercise
import com.leet.moglog.workout.WorkoutPlanTemplate
import com.leet.moglog.workout.enums.WorkoutSplit

object ArmsTorsoLegsTemplates : WorkoutPlanProvider {
    override fun getPlans(): List<WorkoutPlanTemplate> {
        return listOf(
            classicThreeDay(),
            armPriorityFourDay(),
            specializationSixDay()
        )
    }

    fun classicThreeDay(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.ARMS_TORSO_LEGS,
            name = "Classic Arms Torso Legs",
            description = "3 day hypertrophy split with a dedicated arm day",
            workoutDaysPerWeek = 3,
            supportedStyles = setOf(TrainingStyle.HYPERTROPHY),
            supportedGoals = setOf(PrimaryGoal.HYPERTROPHY),
            supportedLevels = setOf(FitnessLevel.INTERMEDIATE),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.CABLE
            ),
            workouts = listOf(
                Workout(
                    name = "Arms",
                    exercises = listOf(
                        WorkoutExercise("barbell_curl", 4, 10, 60),
                        WorkoutExercise("skull_crusher", 4, 10, 60),
                        WorkoutExercise("hammer_curl", 3, 12, 45),
                        WorkoutExercise("triceps_pushdown", 3, 12, 45)
                    )
                ),
                Workout(
                    name = "Torso",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 4, 8, 90),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("overhead_press", 3, 10, 75),
                        WorkoutExercise("lat_pulldown", 3, 10, 60),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Legs",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 4, 8, 120),
                        WorkoutExercise("romanian_deadlift", 3, 10, 90),
                        WorkoutExercise("walking_lunge", 3, 12, 75),
                        WorkoutExercise("calf_raise", 3, 15, 45),
                        WorkoutExercise("crunch", 3, 20, 30)
                    )
                )
            )
        )
    }

    fun armPriorityFourDay(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.ARMS_TORSO_LEGS,
            name = "Arm Priority Arms Torso Legs",
            description = "4 day split that repeats arms for extra weekly arm volume",
            workoutDaysPerWeek = 4,
            supportedStyles = setOf(TrainingStyle.HYPERTROPHY),
            supportedGoals = setOf(PrimaryGoal.HYPERTROPHY),
            supportedLevels = setOf(FitnessLevel.INTERMEDIATE, FitnessLevel.ADVANCED),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.CABLE,
                Equipment.MACHINE
            ),
            workouts = listOf(
                Workout(
                    name = "Arms A",
                    exercises = listOf(
                        WorkoutExercise("barbell_curl", 4, 8, 60),
                        WorkoutExercise("triceps_pushdown", 4, 10, 45),
                        WorkoutExercise("hammer_curl", 3, 12, 45),
                        WorkoutExercise("lateral_raise", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Torso",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 4, 8, 90),
                        WorkoutExercise("pull_up", 4, 8, 90),
                        WorkoutExercise("seated_cable_row", 3, 10, 60),
                        WorkoutExercise("overhead_press", 3, 8, 75),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Legs",
                    exercises = listOf(
                        WorkoutExercise("leg_press", 4, 10, 90),
                        WorkoutExercise("romanian_deadlift", 4, 8, 90),
                        WorkoutExercise("leg_curl", 3, 12, 60),
                        WorkoutExercise("seated_calf_raise", 3, 15, 45),
                        WorkoutExercise("russian_twist", 3, 20, 30)
                    )
                ),
                Workout(
                    name = "Arms B",
                    exercises = listOf(
                        WorkoutExercise("skull_crusher", 4, 10, 60),
                        WorkoutExercise("hammer_curl", 4, 10, 45),
                        WorkoutExercise("barbell_curl", 3, 12, 45),
                        WorkoutExercise("rear_delt_fly", 3, 15, 45)
                    )
                )
            )
        )
    }

    fun specializationSixDay(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.ARMS_TORSO_LEGS,
            name = "Arms Torso Legs Specialization",
            description = "6 day specialization split rotating heavy and pump sessions",
            workoutDaysPerWeek = 6,
            supportedStyles = setOf(TrainingStyle.HYPERTROPHY),
            supportedGoals = setOf(PrimaryGoal.HYPERTROPHY),
            supportedLevels = setOf(FitnessLevel.ADVANCED),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.CABLE,
                Equipment.MACHINE,
                Equipment.PULLUP_BAR
            ),
            workouts = listOf(
                Workout(
                    name = "Arms Heavy",
                    exercises = listOf(
                        WorkoutExercise("barbell_curl", 4, 8, 60),
                        WorkoutExercise("skull_crusher", 4, 8, 60),
                        WorkoutExercise("hammer_curl", 3, 10, 45),
                        WorkoutExercise("triceps_pushdown", 3, 10, 45)
                    )
                ),
                Workout(
                    name = "Torso Heavy",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 4, 6, 120),
                        WorkoutExercise("barbell_row", 4, 6, 120),
                        WorkoutExercise("overhead_press", 4, 8, 90),
                        WorkoutExercise("pull_up", 3, 8, 90)
                    )
                ),
                Workout(
                    name = "Legs Heavy",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 4, 6, 120),
                        WorkoutExercise("deadlift", 3, 5, 150),
                        WorkoutExercise("walking_lunge", 3, 10, 75),
                        WorkoutExercise("calf_raise", 4, 12, 45)
                    )
                ),
                Workout(
                    name = "Arms Pump",
                    exercises = listOf(
                        WorkoutExercise("hammer_curl", 4, 12, 45),
                        WorkoutExercise("triceps_pushdown", 4, 12, 45),
                        WorkoutExercise("barbell_curl", 3, 15, 45),
                        WorkoutExercise("lateral_raise", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Torso Pump",
                    exercises = listOf(
                        WorkoutExercise("incline_dumbbell_press", 4, 10, 75),
                        WorkoutExercise("lat_pulldown", 4, 10, 60),
                        WorkoutExercise("seated_cable_row", 3, 12, 60),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Legs Pump",
                    exercises = listOf(
                        WorkoutExercise("leg_press", 4, 12, 75),
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
