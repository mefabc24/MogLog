package com.leet.moglog.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leet.moglog.ui.components.DetailCard
import com.leet.moglog.ui.components.MetricCard
import com.leet.moglog.ui.components.PrototypeColors
import kotlinx.coroutines.delay

@Composable
fun PrototypePageScreen(
    eyebrow: String,
    title: String,
    metricTitle: String,
    metricValue: Int,
    metricUnit: String,
    progressCount: Int,
    detailTitle: String,
    detailBody: String,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showHeader by rememberSaveable(title) { mutableStateOf(false) }
    var showMetric by rememberSaveable(title) { mutableStateOf(false) }
    var showDetail by rememberSaveable(title) { mutableStateOf(false) }
    var showButton by rememberSaveable(title) { mutableStateOf(false) }

    LaunchedEffect(title) {
        showHeader = false
        showMetric = false
        showDetail = false
        showButton = false
        showHeader = true
        delay(70)
        showMetric = true
        delay(90)
        showDetail = true
        delay(80)
        showButton = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        AnimatedVisibility(
            visible = showHeader,
            enter = fadeIn(tween(320)) + slideInVertically(
                initialOffsetY = { it / 3 },
                animationSpec = tween(420, easing = FastOutSlowInEasing)
            ),
            label = "headerReveal"
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = eyebrow.uppercase(),
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    ),
                    color = PrototypeColors.AccentSoft
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = PrototypeColors.TextPrimary
                )
            }
        }

        AnimatedVisibility(
            visible = showMetric,
            enter = fadeIn(tween(360)) + slideInVertically(
                initialOffsetY = { it / 4 },
                animationSpec = tween(450, easing = FastOutSlowInEasing)
            ),
            label = "metricReveal"
        ) {
            MetricCard(
                title = metricTitle,
                value = metricValue,
                unit = metricUnit,
                activeBlocks = progressCount
            )
        }

        AnimatedVisibility(
            visible = showDetail,
            enter = fadeIn(tween(360)) + slideInVertically(
                initialOffsetY = { it / 5 },
                animationSpec = tween(470, easing = FastOutSlowInEasing)
            ),
            label = "detailReveal"
        ) {
            DetailCard(
                title = detailTitle,
                value = metricValue,
                body = detailBody
            )
        }

        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(tween(360)) + slideInVertically(
                initialOffsetY = { it / 4 },
                animationSpec = tween(460, easing = FastOutSlowInEasing)
            ),
            label = "buttonReveal"
        ) {
            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrototypeColors.Accent,
                    contentColor = PrototypeColors.TextPrimary
                ),
                shape = RoundedCornerShape(2.dp)
            ) {
                Text(
                    text = "NEXT ->",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                )
            }
        }
    }
}
