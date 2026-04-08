package com.leet.moglog.helper

import com.leet.moglog.infrastructure.json.JsonLoader
import java.lang.reflect.Type

class TestJsonService(private val mockData: Any) : JsonLoader {
    @Suppress("UNCHECKED_CAST")
    override fun <T> loadFromAssets(fileName: String, type: Type): T {
        return mockData as T
    }
}