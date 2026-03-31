package com.fabi.moglog.model.enums

enum class Muscle {

    // ==========================================
    // ARMS
    // ==========================================

    // BICEPS
    BICEPS_SHORT_HEAD,
    BICEPS_LONG_HEAD,
    BRACHIALIS, // Lies deeper under the biceps, pushes it up to create a thicker arm

    // TRICEPS
    TRICEPS_LONG_HEAD,
    TRICEPS_LATERAL_HEAD,
    TRICEPS_MEDIAL_HEAD, // Lies deeper, visible near the elbow

    // FOREARM
    BRACHIORADIALIS, // Prominent during hammer curls
    WRIST_FLEXORS,
    WRIST_EXTENSORS,

    // ==========================================
    // LEGS
    // ==========================================

    // QUADRICEPS
    RECTUS_FEMORIS, // Middle quad muscle
    VASTUS_LATERALIS, // Outer quad (creates the "quad sweep")
    VASTUS_MEDIALIS, // Inner teardrop muscle above the knee
    VASTUS_INTERMEDIUS, // Deep middle quad

    // HAMSTRINGS
    BICEPS_FEMORIS,
    SEMITENDINOSUS, // Inner/middle hamstring
    SEMIMEMBRANOSUS, // Deep inner hamstring

    // GLUTES
    GLUTEUS_MAXIMUS,
    GLUTEUS_MEDIUS, // Upper side of the glutes
    GLUTEUS_MINIMUS, // Deep glute muscle

    // CALVES
    GASTROCNEMIUS, // Main visible calf muscle
    SOLEUS, // Deep calf muscle, mostly trained seated
    TIBIALIS_ANTERIOR, // Front shin muscle

    // HIP_FLEXORS
    ILIOPSOAS, // Main deep hip flexor
    SARTORIUS, // Longest muscle in the body, crosses the thigh

    // ADDUCTORS
    ADDUCTOR_LONGUS,
    ADDUCTOR_MAGNUS,
    ADDUCTOR_BREVIS,
    GRACILIS, // Inner thigh muscle

    // ABDUCTORS
    TENSOR_FASCIAE_LATAE, // TFL, assists in hip abduction

    // ==========================================
    // UPPER BODY
    // ==========================================

    // CHEST
    PECTORALIS_MAJOR_CLAVICULAR, // Upper chest
    PECTORALIS_MAJOR_STERNAL, // Mid chest
    PECTORALIS_MAJOR_COSTAL, // Lower chest
    PECTORALIS_MINOR, // Deep chest muscle beneath the major

    // CORE
    RECTUS_ABDOMINIS,
    EXTERNAL_OBLIQUES,
    INTERNAL_OBLIQUES, // Deep obliques
    TRANSVERSUS_ABDOMINIS, // Deep core corset, stabilizes spine
    SERRATUS_ANTERIOR, // Finger-like rib muscles visible under the armpit/chest

    // SHOULDERS
    ANTERIOR_DELTOID,
    LATERAL_DELTOID,
    POSTERIOR_DELTOID,
    ROTATOR_CUFF, // Group of deep stabilizing shoulder muscles

    // LATS
    LATISSIMUS_DORSI,
    TERES_MAJOR, // "Little lat", assists the latissimus dorsi

    // TRAPS
    UPPER_TRAPEZIUS,
    MIDDLE_TRAPEZIUS,
    LOWER_TRAPEZIUS,

    // RHOMBOIDS
    RHOMBOID_MAJOR, // Upper back muscles between the shoulder blades
    RHOMBOID_MINOR,

    // LOWER_BACK
    ERECTOR_SPINAE, // Spinal erectors, run along the spine
    MULTIFIDUS, // Deep spine stabilizers
    QUADRATUS_LUMBORUM // QL, deep lower back/pelvis stabilizer
}