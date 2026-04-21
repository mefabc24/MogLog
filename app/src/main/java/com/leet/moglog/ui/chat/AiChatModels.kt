package com.leet.moglog.ui.chat

enum class ChatAuthor {
    User,
    Assistant
}

data class ChatUiMessage(
    val id: Long,
    val author: ChatAuthor,
    val text: String,
    val includeInContext: Boolean = true
)
