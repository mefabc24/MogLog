package com.leet.moglog.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import com.leet.moglog.infrastructure.ai.AiChatMessage
import com.leet.moglog.infrastructure.ai.AiChatResult
import com.leet.moglog.infrastructure.ai.AiService
import com.leet.moglog.ui.chat.AiChatFab
import com.leet.moglog.ui.chat.AiChatOverlay
import com.leet.moglog.ui.chat.ChatAuthor
import com.leet.moglog.ui.chat.ChatUiMessage
import com.leet.moglog.ui.components.PrototypeColors
import com.leet.moglog.ui.navigation.MainBottomBar
import com.leet.moglog.ui.navigation.MainDestination
import com.leet.moglog.ui.navigation.MainNavigationContent
import com.leet.moglog.ui.theme.MogLogTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedDestinationName by rememberSaveable { mutableStateOf(MainDestination.Dashboard.name) }
    var isChatOpen by rememberSaveable { mutableStateOf(false) }
    var chatDraft by rememberSaveable { mutableStateOf("") }
    var isSending by rememberSaveable { mutableStateOf(false) }
    val selectedDestination = MainDestination.valueOf(selectedDestinationName)
    val isInPreview = LocalInspectionMode.current
    val coroutineScope = rememberCoroutineScope()
    val aiService = remember { AiService() }
    val chatMessages = remember { mutableStateListOf<ChatUiMessage>() }
    var nextChatId by remember { mutableStateOf(0L) }

    fun appendMessage(
        author: ChatAuthor,
        text: String,
        includeInContext: Boolean = true
    ) {
        chatMessages += ChatUiMessage(
            id = nextChatId++,
            author = author,
            text = text,
            includeInContext = includeInContext
        )
    }

    LaunchedEffect(isChatOpen) {
        if (isChatOpen && chatMessages.isEmpty()) {
            appendMessage(
                author = ChatAuthor.Assistant,
                text = "Frag mich etwas zu Training, Recovery oder Ernaehrung. Ich merke mir den bisherigen Verlauf in diesem Chat.",
                includeInContext = false
            )
        }
    }

    fun buildAiHistory(): List<AiChatMessage> {
        return chatMessages
            .filter { it.includeInContext }
            .map { message ->
                AiChatMessage(
                    role = if (message.author == ChatAuthor.User) "user" else "assistant",
                    content = message.text
                )
            }
    }

    fun submitChatMessage() {
        val prompt = chatDraft.trim()
        if (prompt.isEmpty() || isSending) {
            return
        }

        appendMessage(author = ChatAuthor.User, text = prompt)
        chatDraft = ""
        isSending = true

        coroutineScope.launch {
            val result = try {
                if (isInPreview) {
                    delay(450)
                    AiChatResult(
                        message = "Preview-Antwort: Fuer Muskelaufbau sind progressive Ueberlastung, genug Schlaf und konstante Kalorienzufuhr entscheidend.",
                        isError = false
                    )
                } else {
                    withContext(Dispatchers.IO) {
                        aiService.sendMessages(buildAiHistory())
                    }
                }
            } catch (exception: Exception) {
                AiChatResult(
                    message = "Fallback: ${exception.message ?: "Unbekannter Fehler"}",
                    isError = true
                )
            }

            appendMessage(
                author = ChatAuthor.Assistant,
                text = result.message,
                includeInContext = !result.isError
            )
            isSending = false
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = PrototypeColors.Background,
        floatingActionButton = {
            AnimatedVisibility(
                visible = !isChatOpen,
                enter = fadeIn(),
                exit = fadeOut(),
                label = "chatFabVisibility"
            ) {
                AiChatFab(onClick = { isChatOpen = true })
            }
        },
        bottomBar = {
            MainBottomBar(
                selectedDestination = selectedDestination,
                onDestinationSelected = { selectedDestinationName = it.name }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(PrototypeColors.Background)
                .padding(innerPadding)
        ) {
            MainNavigationContent(
                selectedDestination = selectedDestination,
                onNavigate = { selectedDestinationName = it.name },
                modifier = Modifier.fillMaxSize()
            )

            AiChatOverlay(
                visible = isChatOpen,
                messages = chatMessages,
                draft = chatDraft,
                isSending = isSending,
                onDraftChange = { chatDraft = it },
                onSend = ::submitChatMessage,
                onClose = { isChatOpen = false }
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF111214)
@Composable
private fun MainScreenPreview() {
    MogLogTheme {
        MainScreen()
    }
}

