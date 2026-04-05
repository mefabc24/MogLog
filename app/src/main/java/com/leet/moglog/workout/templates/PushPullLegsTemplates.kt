package com.leet.moglog.workout.templates

import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.workout.Workout
import com.leet.moglog.workout.WorkoutExercise
import com.leet.moglog.workout.WorkoutPlanDraft
import com.leet.moglog.workout.enums.WorkoutSplit

object PushPullLegsTemplates : WorkoutPlanTemplate {
    override val split = WorkoutSplit.PUSH_PULL_LEGS

    override fun getPlans(): List<WorkoutPlanDraft> {
        return listOf(
            classic(),
            advanced()
        )
    }

    fun classic(): WorkoutPlanDraft {
        return createPlanDraft(
            name = "Classic PPL",
            description = "6 day hypertrophy split",
            workoutDaysPerWeek = 6,
            trainingStyle = TrainingStyle.HYPERTROPHY,
            workouts = listOf(
                Workout(
                    name = "Push",
                    exercises = listOf(
                        WorkoutExercise("bench_press", 4, 8, 90),
                        WorkoutExercise("shoulder_press", 3, 10, 60),
                        WorkoutExercise("tricep_pushdown", 3, 12, 45)
                    )
                ),
                Workout(
                    name = "Pull",
                    exercises = listOf(
                        WorkoutExercise("lat_pulldown", 4, 10, 60),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("bicep_curl", 3, 12, 45)
                    )
                ),
                Workout(
                    name = "Legs",
                    exercises = listOf(
                        WorkoutExercise("squat", 4, 8, 120),
                        WorkoutExercise("leg_press", 3, 12, 90),
                        WorkoutExercise("leg_curl", 3, 12, 60)
                    )
                ),
                Workout(
                    name = "Push",
                    exercises = listOf(
                        WorkoutExercise("bench_press", 4, 8, 90),
                        WorkoutExercise("shoulder_press", 3, 10, 60),
                        WorkoutExercise("tricep_pushdown", 3, 12, 45)
                    )
                ),
                Workout(
                    name = "Pull",
                    exercises = listOf(
                        WorkoutExercise("lat_pulldown", 4, 10, 60),
                        WorkoutExercise("barbell_row", 4, 8, 90),
                        WorkoutExercise("bicep_curl", 3, 12, 45)
                    )
                ),
                Workout(
                    name = "Legs",
                    exercises = listOf(
                        WorkoutExercise("squat", 4, 8, 120),
                        WorkoutExercise("leg_press", 3, 12, 90),
                        WorkoutExercise("leg_curl", 3, 12, 60)
                    )
                )
            )
        )
    }

    fun advanced(): WorkoutPlanDraft {
        return createPlanDraft(
            name = "Advanced PPL",
            description = "High volume 6 day split",
            workoutDaysPerWeek = 6,
            trainingStyle = TrainingStyle.HYPERTROPHY,
            workouts = listOf(
                Workout(
                    name = "Push",
                    exercises = listOf(
                        WorkoutExercise("incline_bench_press", 4, 8),
                        WorkoutExercise("shoulder_press", 4, 10),
                        WorkoutExercise("lateral_raise", 4, 15),
                        WorkoutExercise("tricep_pushdown", 4, 12)
                    )
                ),
                Workout(
                    name = "Pull",
                    exercises = listOf(
                        WorkoutExercise("weighted_pullup", 4, 8),
                        WorkoutExercise("barbell_row", 4, 8),
                        WorkoutExercise("face_pull", 4, 15),
                        WorkoutExercise("dumbbell_curl", 4, 12)
                    )
                ),
                Workout(
                    name = "Legs",
                    exercises = listOf(
                        WorkoutExercise("back_squat", 4, 8),
                        WorkoutExercise("romanian_deadlift", 4, 10),
                        WorkoutExercise("leg_extension", 4, 15),
                        WorkoutExercise("standing_calf_raise", 4, 20)
                    )
                ),
                Workout(
                    name = "Push",
                    exercises = listOf(
                        WorkoutExercise("incline_bench_press", 4, 8),
                        WorkoutExercise("shoulder_press", 4, 10),
                        WorkoutExercise("lateral_raise", 4, 15),
                        WorkoutExercise("tricep_pushdown", 4, 12)
                    )
                ),
                Workout(
                    name = "Pull",
                    exercises = listOf(
                        WorkoutExercise("weighted_pullup", 4, 8),
                        WorkoutExercise("barbell_row", 4, 8),
                        WorkoutExercise("face_pull", 4, 15),
                        WorkoutExercise("dumbbell_curl", 4, 12)
                    )
                ),
                Workout(
                    name = "Legs",
                    exercises = listOf(
                        WorkoutExercise("back_squat", 4, 8),
                        WorkoutExercise("romanian_deadlift", 4, 10),
                        WorkoutExercise("leg_extension", 4, 15),
                        WorkoutExercise("standing_calf_raise", 4, 20)
                    )
                )
            )
        )
    }
}
