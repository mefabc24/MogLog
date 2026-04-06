package com.leet.moglog.workout.templates

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutExercise
import com.leet.moglog.workout.WorkoutPlanTemplate
import com.leet.moglog.workout.enums.WorkoutSplit

object TorsoLimbsTemplates : WorkoutPlanProvider {
    override fun getPlans(): List<WorkoutPlanTemplate> {
        return listOf(
            upperFocusThreeDay(),
            standardFourDay(),
            balancedSixDay()
        )
    }

    fun upperFocusThreeDay(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.TORSO_LIMB_SPLIT,
            name = "Upper Focus Torso Limb",
            description = "3 day torso limb split with extra weekly torso exposure",
            workoutDaysPerWeek = 3,
            supportedStyles = setOf(TrainingStyle.HYPERTROPHY),
            supportedGoals = setOf(PrimaryGoal.HYPERTROPHY),
            supportedLevels = setOf(FitnessLevel.INTERMEDIATE),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.CABLE,
                Equipment.PULLUP_BAR
            ),
            workouts = listOf(
                Workout(
                    name = "Torso A",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 4, 8, 90),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("overhead_press", 3, 10, 75),
                        WorkoutExercise("lat_pulldown", 3, 10, 60)
                    )
                ),
                Workout(
                    name = "Limbs",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 4, 8, 120),
                        WorkoutExercise("walking_lunge", 3, 12, 75),
                        WorkoutExercise("barbell_curl", 3, 10, 45),
                        WorkoutExercise("skull_crusher", 3, 10, 45),
                        WorkoutExercise("calf_raise", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Torso B",
                    exercises = listOf(
                        WorkoutExercise("incline_dumbbell_press", 4, 10, 75),
                        WorkoutExercise("pull_up", 4, 8, 90),
                        WorkoutExercise("seated_cable_row", 3, 10, 60),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                )
            )
        )
    }

    fun standardFourDay(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.TORSO_LIMB_SPLIT,
            name = "Standard Torso Limb",
            description = "4 day torso limb split balancing upper body and limb development",
            workoutDaysPerWeek = 4,
            supportedStyles = setOf(TrainingStyle.HYPERTROPHY),
            supportedGoals = setOf(PrimaryGoal.HYPERTROPHY),
            supportedLevels = setOf(FitnessLevel.INTERMEDIATE, FitnessLevel.ADVANCED),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.CABLE,
                Equipment.PULLUP_BAR,
                Equipment.MACHINE
            ),
            workouts = listOf(
                Workout(
                    name = "Torso A",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 4, 8, 90),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("overhead_press", 3, 8, 75),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Limbs A",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 4, 8, 120),
                        WorkoutExercise("romanian_deadlift", 3, 10, 90),
                        WorkoutExercise("barbell_curl", 3, 10, 45),
                        WorkoutExercise("triceps_pushdown", 3, 12, 45),
                        WorkoutExercise("seated_calf_raise", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Torso B",
                    exercises = listOf(
                        WorkoutExercise("incline_dumbbell_press", 4, 10, 75),
                        WorkoutExercise("pull_up", 4, 8, 90),
                        WorkoutExercise("lat_pulldown", 3, 12, 60),
                        WorkoutExercise("rear_delt_fly", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Limbs B",
                    exercises = listOf(
                        WorkoutExercise("leg_press", 4, 10, 90),
                        WorkoutExercise("walking_lunge", 3, 12, 75),
                        WorkoutExercise("hammer_curl", 3, 12, 45),
                        WorkoutExercise("skull_crusher", 3, 10, 45),
                        WorkoutExercise("calf_raise", 3, 15, 45)
                    )
                )
            )
        )
    }

    fun balancedSixDay(): WorkoutPlanTemplate {
        return createTemplate(
            split = WorkoutSplit.TORSO_LIMB_SPLIT,
            name = "Balanced Torso Limb Performance",
            description = "6 day torso limb split combining compounds, accessory work and core",
            workoutDaysPerWeek = 6,
            supportedStyles = setOf(
                TrainingStyle.BALANCED,
                TrainingStyle.HYPERTROPHY,
                TrainingStyle.ATHLETIC_FUNCTIONAL
            ),
            supportedGoals = setOf(
                PrimaryGoal.HYPERTROPHY,
                PrimaryGoal.ENDURANCE,
                PrimaryGoal.HEALTH
            ),
            supportedLevels = setOf(FitnessLevel.INTERMEDIATE, FitnessLevel.ADVANCED),
            requiredEquipment = setOf(
                Equipment.BARBELL,
                Equipment.BENCH,
                Equipment.CABLE,
                Equipment.MACHINE,
                Equipment.PULLUP_BAR
            ),
            workouts = listOf(
                Workout(
                    name = "Torso Strength",
                    exercises = listOf(
                        WorkoutExercise("barbell_bench_press", 5, 5, 120),
                        WorkoutExercise("barbell_row", 5, 5, 120),
                        WorkoutExercise("overhead_press", 4, 6, 90)
                    )
                ),
                Workout(
                    name = "Limbs Strength",
                    exercises = listOf(
                        WorkoutExercise("barbell_squat", 5, 5, 120),
                        WorkoutExercise("romanian_deadlift", 4, 6, 90),
                        WorkoutExercise("barbell_curl", 3, 8, 60),
                        WorkoutExercise("skull_crusher", 3, 8, 60)
                    )
                ),
                Workout(
                    name = "Torso Hypertrophy",
                    exercises = listOf(
                        WorkoutExercise("incline_dumbbell_press", 4, 10, 75),
                        WorkoutExercise("lat_pulldown", 4, 10, 60),
                        WorkoutExercise("seated_cable_row", 3, 12, 60),
                        WorkoutExercise("face_pull", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Limbs Hypertrophy",
                    exercises = listOf(
                        WorkoutExercise("leg_press", 4, 12, 75),
                        WorkoutExercise("walking_lunge", 3, 12, 60),
                        WorkoutExercise("hammer_curl", 3, 12, 45),
                        WorkoutExercise("triceps_pushdown", 3, 12, 45),
                        WorkoutExercise("seated_calf_raise", 4, 15, 45)
                    )
                ),
                Workout(
                    name = "Torso Pump",
                    exercises = listOf(
                        WorkoutExercise("push_up", 3, 20, 45),
                        WorkoutExercise("pull_up", 3, 8, 75),
                        WorkoutExercise("lateral_raise", 3, 15, 45),
                        WorkoutExercise("rear_delt_fly", 3, 15, 45)
                    )
                ),
                Workout(
                    name = "Limbs Pump",
                    exercises = listOf(
                        WorkoutExercise("leg_extension", 3, 15, 45),
                        WorkoutExercise("leg_curl", 3, 15, 45),
                        WorkoutExercise("calf_raise", 4, 15, 45),
                        WorkoutExercise("russian_twist", 3, 20, 30),
                        WorkoutExercise("crunch", 3, 20, 30)
                    )
                )
            )
        )
    }
}
