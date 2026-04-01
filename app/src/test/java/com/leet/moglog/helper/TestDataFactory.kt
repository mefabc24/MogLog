package com.leet.moglog.helper

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.exercise.Exercise
import com.leet.moglog.exercise.MuscleTarget
import com.leet.moglog.exercise.enums.Difficulty
import com.leet.moglog.exercise.enums.EffectivenessLevel
import com.leet.moglog.exercise.enums.Muscle

object TestDataFactory {
    fun createExercises(): List<Exercise> {
        return listOf(
            Exercise(
                id = "bench_press",
                name = "Bench Press",
                description = "Classic chest compound exercise.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.PECTORALIS_MAJOR_STERNAL, EffectivenessLevel.HIGH),
                    MuscleTarget(Muscle.TRICEPS_LONG_HEAD, EffectivenessLevel.MEDIUM),
                    MuscleTarget(Muscle.ANTERIOR_DELTOID, EffectivenessLevel.LOW)
                ),
                difficulty = Difficulty.INTERMEDIATE,
                equipment = listOf(Equipment.BARBELL, Equipment.BENCH)
            ),
            Exercise(
                id = "incline_press",
                name = "Incline Press",
                description = "Upper chest focused press.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.PECTORALIS_MAJOR_CLAVICULAR, EffectivenessLevel.HIGH),
                    MuscleTarget(Muscle.ANTERIOR_DELTOID, EffectivenessLevel.MEDIUM)
                ),
                difficulty = Difficulty.INTERMEDIATE,
                equipment = listOf(Equipment.DUMBBELL, Equipment.BENCH)
            ),
            Exercise(
                id = "push_up",
                name = "Push Up",
                description = "Bodyweight push exercise.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.PECTORALIS_MAJOR_STERNAL, EffectivenessLevel.HIGH),
                    MuscleTarget(Muscle.TRICEPS_LATERAL_HEAD, EffectivenessLevel.MEDIUM)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.BODYWEIGHT)
            ),
            Exercise(
                id = "squat",
                name = "Squat",
                description = "Classic lower body compound lift.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.RECTUS_FEMORIS, EffectivenessLevel.HIGH),
                    MuscleTarget(Muscle.GLUTEUS_MAXIMUS, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.INTERMEDIATE,
                equipment = listOf(Equipment.BARBELL, Equipment.RACK)
            ),
            Exercise(
                id = "deadlift",
                name = "Deadlift",
                description = "Posterior chain full body lift.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.BICEPS_FEMORIS, EffectivenessLevel.HIGH),
                    MuscleTarget(Muscle.ERECTOR_SPINAE, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.ADVANCED,
                equipment = listOf(Equipment.BARBELL)
            ),
            Exercise(
                id = "pull_up",
                name = "Pull Up",
                description = "Vertical pulling bodyweight exercise.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.LATISSIMUS_DORSI, EffectivenessLevel.HIGH),
                    MuscleTarget(Muscle.BICEPS_LONG_HEAD, EffectivenessLevel.MEDIUM)
                ),
                difficulty = Difficulty.INTERMEDIATE,
                equipment = listOf(Equipment.PULLUP_BAR)
            ),
            Exercise(
                id = "lat_pulldown",
                name = "Lat Pulldown",
                description = "Machine variation of pull up.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.LATISSIMUS_DORSI, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.CABLE)
            ),
            Exercise(
                id = "barbell_row",
                name = "Barbell Row",
                description = "Horizontal back pulling movement.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.LATISSIMUS_DORSI, EffectivenessLevel.HIGH),
                    MuscleTarget(Muscle.RHOMBOID_MAJOR, EffectivenessLevel.MEDIUM)
                ),
                difficulty = Difficulty.INTERMEDIATE,
                equipment = listOf(Equipment.BARBELL)
            ),
            Exercise(
                id = "overhead_press",
                name = "Overhead Press",
                description = "Shoulder pressing movement.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.ANTERIOR_DELTOID, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.INTERMEDIATE,
                equipment = listOf(Equipment.BARBELL)
            ),
            Exercise(
                id = "lateral_raise",
                name = "Lateral Raise",
                description = "Shoulder isolation movement.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.LATERAL_DELTOID, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.DUMBBELL)
            ),
            Exercise(
                id = "rear_delt_fly",
                name = "Rear Delt Fly",
                description = "Rear shoulder isolation.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.POSTERIOR_DELTOID, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.DUMBBELL)
            ),
            Exercise(
                id = "barbell_curl",
                name = "Barbell Curl",
                description = "Biceps isolation exercise.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.BICEPS_LONG_HEAD, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.BARBELL)
            ),
            Exercise(
                id = "hammer_curl",
                name = "Hammer Curl",
                description = "Neutral grip curl variation.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.BRACHIALIS, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.DUMBBELL)
            ),
            Exercise(
                id = "triceps_pushdown",
                name = "Triceps Pushdown",
                description = "Cable triceps isolation.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.TRICEPS_LATERAL_HEAD, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.CABLE)
            ),
            Exercise(
                id = "walking_lunge",
                name = "Walking Lunge",
                description = "Unilateral leg movement.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.RECTUS_FEMORIS, EffectivenessLevel.HIGH),
                    MuscleTarget(Muscle.GLUTEUS_MAXIMUS, EffectivenessLevel.MEDIUM)
                ),
                difficulty = Difficulty.INTERMEDIATE,
                equipment = listOf(Equipment.DUMBBELL)
            ),
            Exercise(
                id = "calf_raise",
                name = "Calf Raise",
                description = "Calf isolation exercise.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.GASTROCNEMIUS, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.BODYWEIGHT)
            ),
            Exercise(
                id = "crunch",
                name = "Crunch",
                description = "Abdominal flexion exercise.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.RECTUS_ABDOMINIS, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.BODYWEIGHT)
            ),
            Exercise(
                id = "plank",
                name = "Plank",
                description = "Core stability exercise.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.TRANSVERSUS_ABDOMINIS, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.BODYWEIGHT)
            ),
            Exercise(
                id = "face_pull",
                name = "Face Pull",
                description = "Rear delt and upper back cable exercise.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.POSTERIOR_DELTOID, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.BEGINNER,
                equipment = listOf(Equipment.CABLE)
            ),
            Exercise(
                id = "hip_thrust",
                name = "Hip Thrust",
                description = "Glute focused movement.",
                imageUrl = null,
                videoUrl = null,
                muscleTarget = listOf(
                    MuscleTarget(Muscle.GLUTEUS_MAXIMUS, EffectivenessLevel.HIGH)
                ),
                difficulty = Difficulty.INTERMEDIATE,
                equipment = listOf(Equipment.BARBELL, Equipment.BENCH)
            )
        )
    }
}