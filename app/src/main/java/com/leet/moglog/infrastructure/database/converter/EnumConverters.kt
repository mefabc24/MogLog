package com.leet.moglog.infrastructure.database.converter

import androidx.room.TypeConverter
import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.profile.enums.FitnessLevel
import com.leet.moglog.profile.enums.PrimaryGoal
import com.leet.moglog.profile.enums.TrainingLocation
import com.leet.moglog.profile.enums.TrainingStyle
import com.leet.moglog.user.enums.Gender

class EnumConverters {

    // PrimaryGoal Enum Converters
    @TypeConverter fun fromPrimaryGoal(primaryGoal: PrimaryGoal?): String? = primaryGoal?.name
    @TypeConverter fun toPrimaryGoal(value: String?): PrimaryGoal? = value?.let { PrimaryGoal.valueOf(it) }

    // FitnessLevel Enum Converters
    @TypeConverter fun fromFitnessLevel(fitnessLevel: FitnessLevel?): String? = fitnessLevel?.name
    @TypeConverter fun toFitnessLevel(value: String?): FitnessLevel? = value?.let { FitnessLevel.valueOf(it) }

    // TrainingStyle Enum Converters
    @TypeConverter fun fromTrainingStyle(trainingStyle: TrainingStyle?): String? = trainingStyle?.name
    @TypeConverter fun toTrainingStyle(value: String?): TrainingStyle? = value?.let { TrainingStyle.valueOf(it) }

    // TrainingLocation Enum Converters
    @TypeConverter fun fromTrainingLocation(trainingLocation: TrainingLocation?): String? = trainingLocation?.name
    @TypeConverter fun toTrainingLocation(value: String?): TrainingLocation? = value?.let { TrainingLocation.valueOf(it) }

    // Equipment Enum Converters
    @TypeConverter fun fromEquipment(equipment: Equipment?): String? = equipment?.name
    @TypeConverter fun toEquipment(value: String?): Equipment? = value?.let { Equipment.valueOf(it) }

    // Gender Enum Converters
    @TypeConverter fun fromGender(gender: Gender?): String? = gender?.name
    @TypeConverter fun toGender(value: String?): Gender? = value?.let { Gender.valueOf(it) }
}