package com.fabi.moglog.model.enums

enum class Muscle(val group: MuscleGroup) {

    // ==========================================
    // ARMS
    // ==========================================

    // BICEPS
    BICEPS_SHORT_HEAD(MuscleGroup.BICEPS),
    BICEPS_LONG_HEAD(MuscleGroup.BICEPS),
    BRACHIALIS(MuscleGroup.BICEPS),

    // TRICEPS
    TRICEPS_LONG_HEAD(MuscleGroup.TRICEPS),
    TRICEPS_LATERAL_HEAD(MuscleGroup.TRICEPS),
    TRICEPS_MEDIAL_HEAD(MuscleGroup.TRICEPS),

    // FOREARM
    BRACHIORADIALIS(MuscleGroup.FOREARM),
    WRIST_FLEXORS(MuscleGroup.FOREARM),
    WRIST_EXTENSORS(MuscleGroup.FOREARM),

    // ==========================================
    // LEGS
    // ==========================================

    // QUADRICEPS
    RECTUS_FEMORIS(MuscleGroup.QUADRICEPS), // Middle quad muscle
    VASTUS_LATERALIS(MuscleGroup.QUADRICEPS), // Outer quad
    VASTUS_MEDIALIS(MuscleGroup.QUADRICEPS), // Inner teardrop muscle above the knee
    VASTUS_INTERMEDIUS(MuscleGroup.QUADRICEPS), // Deep middle quad

    // HAMSTRINGS
    BICEPS_FEMORIS(MuscleGroup.HAMSTRINGS),
    SEMITENDINOSUS(MuscleGroup.HAMSTRINGS), // Inner/middle hamstring
    SEMIMEMBRANOSUS(MuscleGroup.HAMSTRINGS), // Deep inner hamstring

    // GLUTES
    GLUTEUS_MAXIMUS(MuscleGroup.GLUTES),
    GLUTEUS_MEDIUS(MuscleGroup.GLUTES), // Upper side of the glutes
    GLUTEUS_MINIMUS(MuscleGroup.GLUTES), // Deep glute muscle

    // CALVES
    GASTROCNEMIUS(MuscleGroup.CALVES), // Main visible calf muscle
    SOLEUS(MuscleGroup.CALVES), // Deep calf muscle, mostly trained seated
    TIBIALIS_ANTERIOR(MuscleGroup.CALVES), // Front shin muscle

    // HIP_FLEXORS
    ILIOPSOAS(MuscleGroup.HIP_FLEXORS), // Main deep hip flexor
    SARTORIUS(MuscleGroup.HIP_FLEXORS), // Longest muscle in the body, crosses the thigh

    // ADDUCTORS
    ADDUCTOR_LONGUS(MuscleGroup.ADDUCTORS),
    ADDUCTOR_MAGNUS(MuscleGroup.ADDUCTORS),
    ADDUCTOR_BREVIS(MuscleGroup.ADDUCTORS),
    GRACILIS(MuscleGroup.ADDUCTORS), // Inner thigh muscle

    // ABDUCTORS
    TENSOR_FASCIAE_LATAE(MuscleGroup.ABDUCTORS), // TFL, assists in hip abduction

    // ==========================================
    // UPPER BODY
    // ==========================================

    // CHEST
    PECTORALIS_MAJOR_CLAVICULAR(MuscleGroup.CHEST), // Upper chest
    PECTORALIS_MAJOR_STERNAL(MuscleGroup.CHEST), // Mid chest
    PECTORALIS_MAJOR_COSTAL(MuscleGroup.CHEST), // Lower chest
    PECTORALIS_MINOR(MuscleGroup.CHEST), // Deep chest muscle beneath the major

    // CORE
    RECTUS_ABDOMINIS(MuscleGroup.CORE),
    EXTERNAL_OBLIQUES(MuscleGroup.CORE),
    INTERNAL_OBLIQUES(MuscleGroup.CORE), // Deep obliques
    TRANSVERSUS_ABDOMINIS(MuscleGroup.CORE), // Deep core corset, stabilizes spine
    SERRATUS_ANTERIOR(MuscleGroup.CORE), // Finger-like rib muscles visible under the armpit/chest

    // SHOULDERS
    ANTERIOR_DELTOID(MuscleGroup.SHOULDERS),
    LATERAL_DELTOID(MuscleGroup.SHOULDERS),
    POSTERIOR_DELTOID(MuscleGroup.SHOULDERS),
    ROTATOR_CUFF(MuscleGroup.SHOULDERS), // Group of deep stabilizing shoulder muscles

    // LATS
    LATISSIMUS_DORSI(MuscleGroup.LATS),
    TERES_MAJOR(MuscleGroup.LATS), // "Little lat", assists the latissimus dorsi

    // TRAPS
    UPPER_TRAPEZIUS(MuscleGroup.TRAPS),
    MIDDLE_TRAPEZIUS(MuscleGroup.TRAPS),
    LOWER_TRAPEZIUS(MuscleGroup.TRAPS),

    // RHOMBOIDS
    RHOMBOID_MAJOR(MuscleGroup.RHOMBOIDS), // Upper back muscles between the shoulder blades
    RHOMBOID_MINOR(MuscleGroup.RHOMBOIDS),

    // LOWER_BACK
    ERECTOR_SPINAE(MuscleGroup.LOWER_BACK), // Spinal erectors, run along the spine
    MULTIFIDUS(MuscleGroup.LOWER_BACK), // Deep spine stabilizers
    QUADRATUS_LUMBORUM(MuscleGroup.LOWER_BACK) // QL, deep lower back/pelvis stabilizer
}