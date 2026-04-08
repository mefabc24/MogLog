package com.leet.moglog.infrastructure.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leet.moglog.common.enums.Equipment
import com.leet.moglog.workout.Workout
import java.time.DayOfWeek

class CollectionConverters {
    private val gson = Gson()

    // Converter for List<Equipment>
    @TypeConverter
    fun fromEquipmentList(list: List<Equipment>?): String? {
        return gson.toJson(list)
    }

    @TypeConverter
    fun toEquipmentList(value: String?): List<Equipment> {
        if (value.isNullOrBlank()) return emptyList()

        val type = object : TypeToken<List<Equipment>>() {}.type
        return gson.fromJson(value, type)
    }

    // Converter for List<Workout>
    @TypeConverter
    fun fromWorkoutList(list: List<Workout>?): String? {
        return gson.toJson(list)
    }

    @TypeConverter
    fun toWorkoutList(value: String?): List<Workout> {
        if (value.isNullOrBlank()) return emptyList()

        val type = object : TypeToken<List<Workout>>() {}.type
        return gson.fromJson(value, type)
    }

    // Converter for Set<DayOfWeek>
    @TypeConverter
    fun fromDayOfWeekSet(days: Set<DayOfWeek>?): String? {
        return gson.toJson(days)
    }

    @TypeConverter
    fun toDayOfWeekSet(value: String?): Set<DayOfWeek> {
        if (value.isNullOrBlank()) return emptySet()

        val type = object : TypeToken<Set<DayOfWeek>>() {}.type
        return gson.fromJson(value, type)
    }
}
