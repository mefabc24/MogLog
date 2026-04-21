package com.leet.moglog.infrastructure.ai

import com.leet.moglog.BuildConfig
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject

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

data class AiChatMessage(
    val role: String,
    val content: String
)

data class AiChatResult(
    val message: String,
    val isError: Boolean
)

class AiService {
    private val client = OkHttpClient()
    private val apiKey = BuildConfig.AI_API_KEY.trim()

    fun sendMessage(message: String): AiChatResult {
        return sendMessages(listOf(AiChatMessage(role = "user", content = message)))
    }

    fun sendMessages(messages: List<AiChatMessage>): AiChatResult {
        if (apiKey.isBlank()) {
            return AiChatResult(
                message = "Kein AI API Key hinterlegt. Bitte trage `AI_API_KEY` in `local.properties` ein.",
                isError = true
            )
        }

        val request = buildRequest(messages)

        return try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    return AiChatResult(
                        message = parseError(response),
                        isError = true
                    )
                }

                AiChatResult(
                    message = parseResponse(response),
                    isError = false
                )
            }
        } catch (exception: Exception) {
            AiChatResult(
                message = "Netzwerkfehler: ${exception.message ?: "Unbekannter Fehler"}",
                isError = true
            )
        }
    }

    private fun buildRequest(messages: List<AiChatMessage>): Request {
        val body = buildRequestBody(messages)
        return Request.Builder()
            .url(API_URL)
            .addHeader("Authorization", "Bearer $apiKey")
            .addHeader("Content-Type", "application/json")
            .post(body)
            .build()
    }

    private fun buildRequestBody(messages: List<AiChatMessage>): RequestBody {
        val json = JSONObject().apply {
            put("model", MODEL)
            put("temperature", TEMPERATURE)
            put("top_p", TOP_P)
            put("max_tokens", MAX_TOKENS)
            put("messages", JSONArray().apply {
                put(
                    JSONObject().apply {
                        put("role", "system")
                        put("content", SYSTEM_INSTRUCTIONS)
                    }
                )

                messages.forEach { message ->
                    put(
                        JSONObject().apply {
                            put("role", message.role)
                            put("content", message.content)
                        }
                    )
                }
            })
        }

        return json.toString().toRequestBody("application/json".toMediaType())
    }

    private fun parseResponse(response: Response): String {
        val body = response.body.string()
        return JSONObject(body)
            .getJSONArray("choices")
            .getJSONObject(0)
            .getJSONObject("message")
            .getString("content")
            .trim()
    }

    private fun parseError(response: Response): String {
        val body = response.body.string()
        if (body.isBlank()) {
            return "AI Anfrage fehlgeschlagen (${response.code})."
        }

        return try {
            val json = JSONObject(body)
            when {
                json.has("error") && json.get("error") is JSONObject -> {
                    val errorObject = json.getJSONObject("error")
                    val message = errorObject.optString("message").ifBlank { null }
                    message?.let { "AI Fehler ${response.code}: $it" }
                        ?: "AI Fehler ${response.code}."
                }

                json.has("message") -> {
                    "AI Fehler ${response.code}: ${json.optString("message")}"
                }

                else -> "AI Fehler ${response.code}: $body"
            }
        } catch (_: Exception) {
            "AI Fehler ${response.code}: $body"
        }
    }
}
