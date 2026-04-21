package com.leet.moglog.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MetricCard(
    title: String,
    value: Int,
    unit: String,
    activeBlocks: Int,
    modifier: Modifier = Modifier
) {
    val animatedValue by animateIntAsState(
        targetValue = value,
        animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing),
        label = "metricValue"
    )

    PrototypeCard(
        backgroundColor = PrototypeColors.SurfaceAlt,
        modifier = modifier
    ) {
        TextLabel(text = title.uppercase())

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = animatedValue.toString(),
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                color = PrototypeColors.TextPrimary
            )
            Text(
                text = unit,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = PrototypeColors.AccentSoft,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        ProgressBlocks(activeBlocks = activeBlocks)
        CardAccentLine()
    }
}

@Composable
fun DetailCard(
    title: String,
    value: Int,
    body: String,
    modifier: Modifier = Modifier
) {
    PrototypeCard(
        backgroundColor = PrototypeColors.Surface,
        modifier = modifier
    ) {
        TextLabel(text = title.uppercase())

        Text(
            text = value.toString(),
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            color = PrototypeColors.TextSecondary.copy(alpha = 0.30f)
        )

        Text(
            text = body,
            style = MaterialTheme.typography.bodyMedium,
            color = PrototypeColors.TextSecondary
        )

        CardAccentLine()
    }
}

@Composable
fun PrototypePanel(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(10.dp)

    Box(
        modifier = modifier
            .clip(shape)
            .background(PrototypeColors.Surface, shape)
            .border(BorderStroke(1.dp, Color.White.copy(alpha = 0.05f)), shape)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            content()
        }
    }
}

@Composable
fun PrototypeCard(
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .border(BorderStroke(1.dp, Color.White.copy(alpha = 0.04f)))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            content()
        }
    }
}

@Composable
fun CardAccentLine(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(PrototypeColors.AccentSoft)
    )
}

@Composable
fun ProgressBlocks(
    activeBlocks: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(4) { index ->
            val isActive = index < activeBlocks
            val animatedWidth by animateDpAsState(
                targetValue = if (isActive) 10.dp else 8.dp,
                animationSpec = tween(420, 80 * index, FastOutSlowInEasing),
                label = "progressWidth$index"
            )
            val animatedColor by animateColorAsState(
                targetValue = if (isActive) PrototypeColors.AccentSoft else PrototypeColors.Divider,
                animationSpec = tween(380, 60 * index, LinearOutSlowInEasing),
                label = "progressColor$index"
            )

            Box(
                modifier = Modifier
                    .width(animatedWidth)
                    .height(5.dp)
                    .background(
                        color = animatedColor,
                        shape = RoundedCornerShape(1.dp)
                    )
            )
        }
    }
}

@Composable
private fun TextLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.6.sp
        ),
        color = PrototypeColors.TextPrimary
    )
}
