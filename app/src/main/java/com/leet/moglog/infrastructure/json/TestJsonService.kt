package com.leet.moglog.infrastructure.json

import java.lang.reflect.Type

class TestJsonService(private val mockData: Any) : JsonLoader {
    @Suppress("UNCHECKED_CAST")
    override fun <T> loadFromAssets(fileName: String, type: Type): T {
        return mockData as T
    }
}