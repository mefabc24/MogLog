package com.leet.moglog.exercise.enums

@Suppress("unused")
enum class MuscleGroup(val region: MuscleRegion) {
    // Arms
    BICEPS(MuscleRegion.ARMS),
    TRICEPS(MuscleRegion.ARMS),
    FOREARM(MuscleRegion.ARMS),

    // Legs
    QUADRICEPS(MuscleRegion.LEGS),
    HAMSTRINGS(MuscleRegion.LEGS),
    GLUTES(MuscleRegion.LEGS),
    CALVES(MuscleRegion.LEGS),
    HIP_FLEXORS(MuscleRegion.LEGS),
    ADDUCTORS(MuscleRegion.LEGS),
    ABDUCTORS(MuscleRegion.LEGS),

    // Upper Body
    CHEST(MuscleRegion.CHEST),
    CORE(MuscleRegion.CORE),
    SHOULDERS(MuscleRegion.SHOULDERS),
    LATS(MuscleRegion.BACK),
    TRAPS(MuscleRegion.BACK),
    RHOMBOIDS(MuscleRegion.BACK),
    LOWER_BACK(MuscleRegion.BACK),
}