package com.leet.moglog.infrastructure.json

import java.lang.reflect.Type

interface JsonLoader {
    fun <T> loadFromAssets(fileName: String, type: Type): T
}