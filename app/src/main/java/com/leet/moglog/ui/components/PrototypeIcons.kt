package com.leet.moglog.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.leet.moglog.ui.navigation.MainIcon

@Composable
fun MainNavIcon(
    icon: MainIcon,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.size(18.dp)) {
        val strokeWidth = 1.8.dp.toPx()
        val sizeUnit = size.minDimension

        when (icon) {
            MainIcon.Grid -> {
                val cell = sizeUnit * 0.28f
                val gap = sizeUnit * 0.08f
                val offsets = listOf(
                    Offset(1f, 1f),
                    Offset(cell + gap + 1f, 1f),
                    Offset(1f, cell + gap + 1f),
                    Offset(cell + gap + 1f, cell + gap + 1f)
                )
                offsets.forEach { offset ->
                    drawRect(
                        color = tint,
                        topLeft = offset,
                        size = Size(cell, cell),
                        style = Stroke(width = strokeWidth)
                    )
                }
            }

            MainIcon.Cross -> {
                drawLine(
                    color = tint,
                    start = Offset(size.width * 0.25f, size.height * 0.22f),
                    end = Offset(size.width * 0.75f, size.height * 0.78f),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
                drawLine(
                    color = tint,
                    start = Offset(size.width * 0.75f, size.height * 0.22f),
                    end = Offset(size.width * 0.25f, size.height * 0.78f),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }

            MainIcon.Chart -> {
                val barWidth = size.width * 0.16f
                val spacing = size.width * 0.10f
                val bars = listOf(0.42f, 0.62f, 0.82f)
                bars.forEachIndexed { index, heightFactor ->
                    val left = size.width * 0.16f + index * (barWidth + spacing)
                    drawRect(
                        color = tint,
                        topLeft = Offset(left, size.height * (1f - heightFactor)),
                        size = Size(barWidth, size.height * heightFactor)
                    )
                }
            }

            MainIcon.List -> {
                repeat(3) { index ->
                    val y = size.height * (0.25f + index * 0.24f)
                    drawLine(
                        color = tint,
                        start = Offset(size.width * 0.15f, y),
                        end = Offset(size.width * 0.85f, y),
                        strokeWidth = strokeWidth,
                        cap = StrokeCap.Round
                    )
                }
            }

            MainIcon.Profile -> {
                drawCircle(
                    color = tint,
                    radius = size.minDimension * 0.18f,
                    center = Offset(size.width * 0.5f, size.height * 0.34f),
                    style = Stroke(width = strokeWidth)
                )
                drawLine(
                    color = tint,
                    start = Offset(size.width * 0.28f, size.height * 0.72f),
                    end = Offset(size.width * 0.72f, size.height * 0.72f),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }
        }
    }
}

@Composable
fun AiChatGlyph(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(18.dp)) {
        val strokeWidth = 1.8.dp.toPx()
        drawRoundRect(
            color = PrototypeColors.TextPrimary,
            topLeft = Offset(size.width * 0.12f, size.height * 0.16f),
            size = Size(size.width * 0.76f, size.height * 0.56f),
            cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx()),
            style = Stroke(width = strokeWidth)
        )
        drawLine(
            color = PrototypeColors.TextPrimary,
            start = Offset(size.width * 0.34f, size.height * 0.72f),
            end = Offset(size.width * 0.22f, size.height * 0.92f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = PrototypeColors.TextPrimary,
            start = Offset(size.width * 0.36f, size.height * 0.38f),
            end = Offset(size.width * 0.64f, size.height * 0.38f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = PrototypeColors.TextPrimary,
            start = Offset(size.width * 0.36f, size.height * 0.52f),
            end = Offset(size.width * 0.58f, size.height * 0.52f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun CloseGlyph(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(16.dp)) {
        val strokeWidth = 1.8.dp.toPx()
        drawLine(
            color = PrototypeColors.TextPrimary,
            start = Offset(size.width * 0.22f, size.height * 0.22f),
            end = Offset(size.width * 0.78f, size.height * 0.78f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = PrototypeColors.TextPrimary,
            start = Offset(size.width * 0.78f, size.height * 0.22f),
            end = Offset(size.width * 0.22f, size.height * 0.78f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun SendGlyph(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(18.dp)) {
        val strokeWidth = 1.8.dp.toPx()
        drawLine(
            color = PrototypeColors.TextPrimary,
            start = Offset(size.width * 0.20f, size.height * 0.50f),
            end = Offset(size.width * 0.74f, size.height * 0.50f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = PrototypeColors.TextPrimary,
            start = Offset(size.width * 0.50f, size.height * 0.26f),
            end = Offset(size.width * 0.76f, size.height * 0.50f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = PrototypeColors.TextPrimary,
            start = Offset(size.width * 0.50f, size.height * 0.74f),
            end = Offset(size.width * 0.76f, size.height * 0.50f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}
