package com.leet.moglog.infrastructure.json

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class JsonService(
    private val context: Context,
    private val gson: Gson = Gson()
    ) {

    fun <T> loadFromAssets(fileName: String, type: Type): T {
        val json = context.assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
        return gson.fromJson(json, type)
    }

    inline fun <reified T> loadFromAssets(fileName: String): T {
        val type = object : TypeToken<T>() {}.type
        return loadFromAssets(fileName, type)
    }
}