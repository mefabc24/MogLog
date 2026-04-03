package com.leet.moglog.workout.enums

enum class WorkoutSplit(
    val sections: Int  // Number of body parts this split divides the body into
) {
    FULL_BODY(1),
    UPPER_LOWER(2),
    TORSO_LIMB_SPLIT(2),
    PUSH_PULL_LEGS(3),
    ARMS_TORSO_LEGS(3),
    BRO_SPLIT(5)
}