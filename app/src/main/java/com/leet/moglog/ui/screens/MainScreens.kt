package com.leet.moglog.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.leet.moglog.ui.navigation.MainDestination

@Composable
fun DashboardScreen(
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    MainDestination.Dashboard.renderPrototypeScreen(
        onNextClick = onNextClick,
        modifier = modifier
    )
}

@Composable
fun TrainScreen(
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    MainDestination.Train.renderPrototypeScreen(
        onNextClick = onNextClick,
        modifier = modifier
    )
}

@Composable
fun IntelScreen(
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    MainDestination.Intel.renderPrototypeScreen(
        onNextClick = onNextClick,
        modifier = modifier
    )
}

@Composable
fun FeedScreen(
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    MainDestination.Feed.renderPrototypeScreen(
        onNextClick = onNextClick,
        modifier = modifier
    )
}

@Composable
fun ProfileScreen(
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    MainDestination.Profile.renderPrototypeScreen(
        onNextClick = onNextClick,
        modifier = modifier
    )
}

@Composable
private fun MainDestination.renderPrototypeScreen(
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    PrototypePageScreen(
        eyebrow = eyebrow,
        title = title,
        metricTitle = metricTitle,
        metricValue = metricValue,
        metricUnit = metricUnit,
        progressCount = progressCount,
        detailTitle = detailTitle,
        detailBody = detailBody,
        onNextClick = onNextClick,
        modifier = modifier
    )
}
