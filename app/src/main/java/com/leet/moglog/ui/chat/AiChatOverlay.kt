package com.leet.moglog.ui.chat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leet.moglog.ui.components.AiChatGlyph
import com.leet.moglog.ui.components.CloseGlyph
import com.leet.moglog.ui.components.PrototypeColors
import com.leet.moglog.ui.components.PrototypePanel
import com.leet.moglog.ui.components.SendGlyph

@Composable
fun AiChatFab(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(58.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(PrototypeColors.Accent)
            .border(
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.08f)),
                shape = RoundedCornerShape(18.dp)
            )
            .clickable(onClick = onClick)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        AiChatGlyph()
    }
}

@Composable
fun AiChatOverlay(
    visible: Boolean,
    messages: List<ChatUiMessage>,
    draft: String,
    isSending: Boolean,
    onDraftChange: (String) -> Unit,
    onSend: () -> Unit,
    onClose: () -> Unit
) {
    val listState = rememberLazyListState()
    val scrollTargetIndex = when {
        isSending -> messages.size
        messages.isNotEmpty() -> messages.lastIndex
        else -> 0
    }

    LaunchedEffect(visible, scrollTargetIndex) {
        if (visible && (messages.isNotEmpty() || isSending)) {
            listState.animateScrollToItem(index = scrollTargetIndex)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(tween(220)),
            exit = fadeOut(tween(180)),
            label = "chatScrim"
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PrototypeColors.Scrim)
                    .clickable(onClick = onClose)
            )
        }

        AnimatedVisibility(
            visible = visible,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .imePadding()
                .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
            enter = fadeIn(tween(220)) + slideInVertically(
                initialOffsetY = { it / 6 },
                animationSpec = tween(360, easing = FastOutSlowInEasing)
            ),
            exit = fadeOut(tween(180)),
            label = "chatOverlay"
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                    val panelHeight = maxHeight.coerceIn(400.dp, 540.dp)
                    val messageListHeight = (panelHeight - 270.dp).coerceIn(120.dp, 280.dp)

                    PrototypePanel(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(panelHeight)
                    ) {
                        ChatHeader(onClose = onClose)

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(messageListHeight)
                                .background(Color(0xFF151619))
                                .border(
                                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.05f)),
                                    shape = RoundedCornerShape(2.dp)
                                )
                                .padding(horizontal = 12.dp, vertical = 14.dp)
                        ) {
                            LazyColumn(
                                state = listState,
                                modifier = Modifier.fillMaxSize(),
                                contentPadding = PaddingValues(vertical = 4.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                items(
                                    items = messages,
                                    key = { it.id }
                                ) { message ->
                                    ChatMessageBubble(message = message)
                                }

                                if (isSending) {
                                    item(key = "typing") {
                                        TypingBubble()
                                    }
                                }
                            }
                        }

                        ChatComposer(
                            draft = draft,
                            isSending = isSending,
                            onDraftChange = onDraftChange,
                            onSend = onSend
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ChatHeader(onClose: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.82f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "FITNESS AI",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                ),
                color = PrototypeColors.AccentSoft
            )
            Text(
                text = "Coach Chat",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                color = PrototypeColors.TextPrimary
            )
            Text(
                text = "Your chat history stays in this conversation.",
                style = MaterialTheme.typography.bodyMedium,
                color = PrototypeColors.TextSecondary
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .size(42.dp)
                .background(PrototypeColors.Accent)
                .border(
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.08f)),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable(onClick = onClose)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            CloseGlyph()
        }
    }
}

@Composable
private fun ChatMessageBubble(message: ChatUiMessage) {
    val isUser = message.author == ChatAuthor.User
    val bubbleColor = if (isUser) PrototypeColors.UserBubble else PrototypeColors.AssistantBubble
    val bubbleShape = RoundedCornerShape(2.dp)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(if (isUser) 0.82f else 0.88f)
                .clip(bubbleShape)
                .background(bubbleColor)
                .border(
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.06f)),
                    shape = bubbleShape
                )
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = if (isUser) "YOU" else "AI",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                ),
                color = if (isUser) PrototypeColors.TextPrimary else PrototypeColors.AccentSoft
            )
            Text(
                text = message.text,
                style = MaterialTheme.typography.bodyLarge,
                color = PrototypeColors.TextPrimary
            )
        }
    }
}

@Composable
private fun TypingBubble() {
    val bubbleShape = RoundedCornerShape(2.dp)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .clip(bubbleShape)
                .background(PrototypeColors.AssistantBubble)
                .border(
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.06f)),
                    shape = bubbleShape
                )
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Text(
                text = "AI is typing...",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = PrototypeColors.TextSecondary
            )
        }
    }
}

@Composable
private fun ChatComposer(
    draft: String,
    isSending: Boolean,
    onDraftChange: (String) -> Unit,
    onSend: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        if (isSending) {
            Text(
                text = "Getting response...",
                style = MaterialTheme.typography.bodySmall,
                color = PrototypeColors.TextSecondary
            )
        }

        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            val buttonSize = 52.dp
            val spacing = 10.dp
            val inputWidth = (maxWidth - buttonSize - spacing).coerceAtLeast(140.dp)
            val inputShape = RoundedCornerShape(8.dp)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(spacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(inputWidth)
                        .clip(inputShape)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF1B1D21),
                                    PrototypeColors.InputBackground
                                )
                            ),
                            shape = inputShape
                        )
                        .border(
                            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.05f)),
                            shape = inputShape
                        )
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                ) {
                    BasicTextField(
                        value = draft,
                        onValueChange = onDraftChange,
                        enabled = !isSending,
                        cursorBrush = SolidColor(PrototypeColors.TextPrimary),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(
                            color = PrototypeColors.TextPrimary
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 38.dp),
                        decorationBox = { innerTextField ->
                            if (draft.isBlank()) {
                                Text(
                                    text = "Ask about training...",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = PrototypeColors.TextSecondary
                                )
                            }
                            innerTextField()
                        }
                    )
                }

                Button(
                    onClick = onSend,
                    enabled = draft.isNotBlank() && !isSending,
                    modifier = Modifier.size(buttonSize),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrototypeColors.Accent,
                        contentColor = PrototypeColors.TextPrimary,
                        disabledContainerColor = PrototypeColors.Divider,
                        disabledContentColor = PrototypeColors.TextSecondary
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    if (isSending) {
                        Text(
                            text = "...",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                        )
                    } else {
                        SendGlyph()
                    }
                }
            }
        }
    }
}
