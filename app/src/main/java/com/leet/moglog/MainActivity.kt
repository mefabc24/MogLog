package com.leet.moglog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leet.moglog.infrastructure.ai.AiService
import com.leet.moglog.ui.theme.MogLogTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MogLogTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AiTestScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AiTestScreen(modifier: Modifier = Modifier) {
    var inputText by rememberSaveable { mutableStateOf("") }
    var responseText by rememberSaveable { mutableStateOf("") }
    var errorText by rememberSaveable { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    val isInPreview = LocalInspectionMode.current
    val sendMessage = remember(isInPreview) {
        if (isInPreview) {
            suspend { _: String -> "Preview-Antwort der AI" }
        } else {
            val aiService = AiService()
            suspend { message: String -> aiService.sendMessage(message) }
        }
    }
    val coroutineScope = rememberCoroutineScope()

    AiTestScreenContent(
        modifier = modifier,
        inputText = inputText,
        responseText = responseText,
        errorText = errorText,
        isLoading = isLoading,
        onInputChange = { inputText = it },
        onSubmit = {
            if (inputText.isBlank()) {
                errorText = "Bitte gib eine Nachricht ein."
                return@AiTestScreenContent
            }

            coroutineScope.launch {
                isLoading = true
                errorText = null

                try {
                    val response = withContext(Dispatchers.IO) {
                        sendMessage(inputText)
                    }
                    responseText = response
                    Log.d("MainActivity", "AI Response: $response")
                } catch (e: Exception) {
                    errorText = e.message ?: "Unbekannter Fehler"
                    Log.e("MainActivity", "AI Anfrage fehlgeschlagen", e)
                } finally {
                    isLoading = false
                }
            }
        }
    )
}

@Composable
private fun AiTestScreenContent(
    modifier: Modifier = Modifier,
    inputText: String,
    responseText: String,
    errorText: String?,
    isLoading: Boolean,
    onInputChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = onInputChange,
            label = { Text("Nachricht") },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        )

        Button(
            onClick = onSubmit,
            enabled = !isLoading,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isLoading) "Sende..." else "Submit")
        }

        Text(text = "Antwort:")
        Text(text = if (responseText.isBlank()) "Noch keine Antwort" else responseText)

        errorText?.let {
            Text(
                text = "Fehler: $it",
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AiTestScreenPreview() {
    MogLogTheme {
        AiTestScreenContent(
            inputText = "Wie oft soll ich trainieren?",
            responseText = "3 bis 4 Einheiten pro Woche sind fuer viele ein guter Start.",
            errorText = null,
            isLoading = false,
            onInputChange = {},
            onSubmit = {}
        )
    }
}
