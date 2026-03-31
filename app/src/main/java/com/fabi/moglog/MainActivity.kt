package com.fabi.moglog

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabi.moglog.services.AiService
import com.fabi.moglog.ui.theme.MogLogTheme
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

    val aiService = remember { AiService() }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Nachricht") },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        )

        Button(
            onClick = {
                if (inputText.isBlank()) {
                    errorText = "Bitte gib eine Nachricht ein."
                    return@Button
                }

                coroutineScope.launch {
                    isLoading = true
                    errorText = null

                    try {
                        val response = withContext(Dispatchers.IO) {
                            aiService.sendMessage(inputText)
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
            },
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
        AiTestScreen()
    }
}