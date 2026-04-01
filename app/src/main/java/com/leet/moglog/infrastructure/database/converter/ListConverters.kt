package com.leet.moglog.infrastructure.database.converter

import androidx.core.view.WindowInsetsCompat
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leet.moglog.common.enums.Equipment

class ListConverters {
    private val gson = Gson()

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
}