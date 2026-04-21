package com.leet.moglog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.leet.moglog.ui.MainScreen
import com.leet.moglog.ui.theme.MogLogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MogLogTheme {
                MainScreen()
            }
        }
    }
}
