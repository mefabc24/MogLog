package com.leet.moglog.exercise

import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.exercise.enums.Difficulty
import com.leet.moglog.exercise.enums.EffectivenessLevel
import com.leet.moglog.exercise.enums.Muscle
import com.leet.moglog.exercise.enums.MuscleGroup
import com.leet.moglog.exercise.enums.MuscleRegion

class ExerciseFilterService {

    // ===== Public API / Main filtering logic =====

    fun filterExercises(
        exercises: List<Exercise>,
        idQuery: String? = null,
        nameQuery: String? = null,
        descriptionQuery: String? = null,
        difficulty: Difficulty? = null,
        requiredEquipment: Set<Equipment> = emptySet(),
        hasImage: Boolean? = null,
        hasVideo: Boolean? = null,
        muscleRegion: MuscleRegion? = null,
        muscleGroup: MuscleGroup? = null,
        muscle: Muscle? = null,
        effectivenessLevel: EffectivenessLevel? = null
    ): List<Exercise> =
        exercises.filter { exercise ->
            exercise.matchesId(idQuery) &&
                exercise.matchesName(nameQuery) &&
                exercise.matchesDescription(descriptionQuery) &&
                exercise.matchesDifficulty(difficulty) &&
                exercise.matchesRequiredEquipment(requiredEquipment) &&
                exercise.matchesImagePresence(hasImage) &&
                exercise.matchesVideoPresence(hasVideo) &&
                exercise.matchesMuscleTarget(
                    muscleRegion = muscleRegion,
                    muscleGroup = muscleGroup,
                    muscle = muscle,
                    effectivenessLevel = effectivenessLevel
                )
        }

    // ===== Private helper predicates =====

    private fun Exercise.matchesId(idQuery: String?): Boolean =
        idQuery.isNullOrBlank() || id.contains(idQuery, ignoreCase = true)

    private fun Exercise.matchesName(nameQuery: String?): Boolean =
        nameQuery.isNullOrBlank() || name.contains(nameQuery, ignoreCase = true)

    private fun Exercise.matchesDescription(descriptionQuery: String?): Boolean =
        descriptionQuery.isNullOrBlank() || description.contains(descriptionQuery, ignoreCase = true)

    private fun Exercise.matchesDifficulty(difficulty: Difficulty?): Boolean =
        difficulty == null || this.difficulty == difficulty

    private fun Exercise.matchesRequiredEquipment(requiredEquipment: Set<Equipment>): Boolean =
        requiredEquipment.isEmpty() || equipment.containsAll(requiredEquipment)

    private fun Exercise.matchesImagePresence(hasImage: Boolean?): Boolean =
        hasImage == null || hasImage == !imageUrl.isNullOrBlank()

    private fun Exercise.matchesVideoPresence(hasVideo: Boolean?): Boolean =
        hasVideo == null || hasVideo == !videoUrl.isNullOrBlank()

    private fun Exercise.matchesMuscleTarget(
        muscleRegion: MuscleRegion?,
        muscleGroup: MuscleGroup?,
        muscle: Muscle?,
        effectivenessLevel: EffectivenessLevel?
    ): Boolean {
        val hasTargetFilters =
            muscleRegion != null ||
                muscleGroup != null ||
                muscle != null ||
                effectivenessLevel != null

        if (!hasTargetFilters) {
            return true
        }

        return muscleTarget.any { target ->
            (muscleRegion == null || target.muscle.group.region == muscleRegion) &&
                (muscleGroup == null || target.muscle.group == muscleGroup) &&
                (muscle == null || target.muscle == muscle) &&
                (effectivenessLevel == null || target.effectivenessLevel == effectivenessLevel)
        }
    }
}