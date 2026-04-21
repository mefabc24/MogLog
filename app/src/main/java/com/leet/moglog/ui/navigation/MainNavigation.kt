package com.leet.moglog.ui.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.leet.moglog.ui.screens.DashboardScreen
import com.leet.moglog.ui.screens.FeedScreen
import com.leet.moglog.ui.screens.IntelScreen
import com.leet.moglog.ui.screens.ProfileScreen
import com.leet.moglog.ui.screens.TrainScreen

@Composable
fun MainNavigationContent(
    selectedDestination: MainDestination,
    onNavigate: (MainDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedContent(
        targetState = selectedDestination,
        modifier = modifier,
        transitionSpec = {
            val movingForward = targetState.ordinal >= initialState.ordinal
            (
                fadeIn(animationSpec = tween(320, 70, LinearOutSlowInEasing)) +
                    slideInHorizontally(
                        animationSpec = tween(420, easing = FastOutSlowInEasing),
                        initialOffsetX = { fullWidth ->
                            if (movingForward) fullWidth / 5 else -fullWidth / 5
                        }
                    )
                ).togetherWith(
                fadeOut(animationSpec = tween(180, easing = LinearOutSlowInEasing)) +
                    slideOutHorizontally(
                        animationSpec = tween(260, easing = FastOutSlowInEasing),
                        targetOffsetX = { fullWidth ->
                            if (movingForward) -fullWidth / 8 else fullWidth / 8
                        }
                    )
                )
        },
        label = "pageTransition"
    ) { destination ->
        when (destination) {
            MainDestination.Dashboard -> DashboardScreen(
                onNextClick = { onNavigate(destination.next()) },
                modifier = Modifier.fillMaxSize()
            )

            MainDestination.Train -> TrainScreen(
                onNextClick = { onNavigate(destination.next()) },
                modifier = Modifier.fillMaxSize()
            )

            MainDestination.Intel -> IntelScreen(
                onNextClick = { onNavigate(destination.next()) },
                modifier = Modifier.fillMaxSize()
            )

            MainDestination.Feed -> FeedScreen(
                onNextClick = { onNavigate(destination.next()) },
                modifier = Modifier.fillMaxSize()
            )

            MainDestination.Profile -> ProfileScreen(
                onNextClick = { onNavigate(destination.next()) },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
