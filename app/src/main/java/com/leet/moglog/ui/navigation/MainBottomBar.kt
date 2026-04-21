package com.leet.moglog.ui.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leet.moglog.ui.components.MainNavIcon
import com.leet.moglog.ui.components.PrototypeColors

@Composable
fun MainBottomBar(
    selectedDestination: MainDestination,
    onDestinationSelected: (MainDestination) -> Unit
) {
    Surface(
        color = PrototypeColors.Surface,
        shadowElevation = 0.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(PrototypeColors.Accent)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                MainDestination.entries.forEach { destination ->
                    val selected = destination == selectedDestination
                    val backgroundColor by animateColorAsState(
                        targetValue = if (selected) PrototypeColors.Accent else Color.Transparent,
                        animationSpec = tween(260, easing = FastOutSlowInEasing),
                        label = "navBackground${destination.name}"
                    )
                    val contentColor by animateColorAsState(
                        targetValue = if (selected) PrototypeColors.TextPrimary else PrototypeColors.TextSecondary,
                        animationSpec = tween(220, easing = LinearOutSlowInEasing),
                        label = "navContent${destination.name}"
                    )
                    val iconSize by animateDpAsState(
                        targetValue = if (selected) 20.dp else 18.dp,
                        animationSpec = spring(dampingRatio = 0.8f, stiffness = 500f),
                        label = "navIconSize${destination.name}"
                    )
                    val scale by animateFloatAsState(
                        targetValue = if (selected) 1f else 0.94f,
                        animationSpec = spring(dampingRatio = 0.8f, stiffness = 500f),
                        label = "navScale${destination.name}"
                    )
                    val alpha by animateFloatAsState(
                        targetValue = if (selected) 1f else 0.82f,
                        animationSpec = tween(220, easing = LinearOutSlowInEasing),
                        label = "navAlpha${destination.name}"
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                                this.alpha = alpha
                            }
                            .background(
                                color = backgroundColor,
                                shape = RoundedCornerShape(2.dp)
                            )
                            .clickable { onDestinationSelected(destination) }
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        MainNavIcon(
                            icon = destination.icon,
                            tint = contentColor,
                            modifier = Modifier.size(iconSize)
                        )
                        Text(
                            text = destination.label.uppercase(),
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            ),
                            color = contentColor,
                            textAlign = TextAlign.Center,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}
