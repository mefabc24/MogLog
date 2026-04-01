package com.fabi.moglog.services

import com.fabi.moglog.BuildConfig
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

// Configurations
private const val API_URL: String = "https://chat-ai.academiccloud.de/v1/chat/completions"
private const val MODEL: String = "gemma-3-27b-it"
private const val SYSTEM_PROMPT: String = "You are a helpful fitness chatbot."

private val RESPONSE_SPECIFICATION: String = """
    Respond in plain chat text with a maximum length of 300 characters.
    No emojis, markdown, lists, or filler phrases.
    Keep the answer concise, direct, and focused on essential information only.
    Use the same language as the user's input.
    Only respond to fitness-related questions.
    If the request is not fitness-related, politely state that only fitness-related questions are supported and ask the user to provide a fitness-related question.
""".trimIndent()

private val SYSTEM_INSTRUCTIONS: String = """
    $SYSTEM_PROMPT
    $RESPONSE_SPECIFICATION
""".trimIndent()

private const val TEMPERATURE: Double = 0.4
private const val TOP_P: Double = 0.8
private const val MAX_TOKENS: Int = 300

class AiService {
    private val client = OkHttpClient()
    private val apiKey = BuildConfig.AI_API_KEY

    // API call
    fun sendMessage(message: String): String {
        val request = buildRequest(message)

        return try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) return "Fehler: ${response.code}"
                parseResponse(response)
            }
        } catch (e: Exception) {
            "Fallback: ${e.message}"
        }
    }

    // Utility functions
    private fun buildRequest(message: String): Request {
        val body = buildRequestBody(message)
        return Request.Builder()
            .url(API_URL)
            .addHeader("Authorization", "Bearer $apiKey")
            .addHeader("Content-Type", "application/json")
            .post(body)
            .build()
    }

    private fun buildRequestBody(message: String): RequestBody {
        val json = JSONObject().apply {
            put("model", MODEL)
            put("temperature", TEMPERATURE)
            put("top_p", TOP_P)
            put("max_tokens", MAX_TOKENS)
            put("messages", JSONArray().apply {
                put(JSONObject().apply { put("role", "system"); put("content", SYSTEM_INSTRUCTIONS) })
                put(JSONObject().apply { put("role", "user");   put("content", message) })
            })
        }
        return json.toString().toRequestBody("application/json".toMediaType())
    }

    private fun parseResponse(response: Response): String {
        val body = response.body?.string() ?: return "Leere Antwort"
        return JSONObject(body)
            .getJSONArray("choices")
            .getJSONObject(0)
            .getJSONObject("message")
            .getString("content")
    }
}