package com.leet.moglog.ui.navigation

enum class MainIcon {
    Grid,
    Cross,
    Chart,
    List,
    Profile
}

enum class MainDestination(
    val label: String,
    val title: String,
    val eyebrow: String,
    val metricTitle: String,
    val metricValue: Int,
    val metricUnit: String,
    val progressCount: Int,
    val detailTitle: String,
    val detailBody: String,
    val icon: MainIcon
) {
    Dashboard(
        label = "Dashboard",
        title = "Dashboard",
        eyebrow = "Prototype Layout",
        metricTitle = "Optimal Capacity",
        metricValue = 60,
        metricUnit = "M",
        progressCount = 3,
        detailTitle = "Overview",
        detailBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam.",
        icon = MainIcon.Grid
    ),
    Train(
        label = "Train",
        title = "Train",
        eyebrow = "Active Session",
        metricTitle = "Endurance",
        metricValue = 28,
        metricUnit = "KM",
        progressCount = 4,
        detailTitle = "Session Notes",
        detailBody = "Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris.",
        icon = MainIcon.Cross
    ),
    Intel(
        label = "Intel",
        title = "Intel",
        eyebrow = "Daily Insight",
        metricTitle = "Recovery",
        metricValue = 84,
        metricUnit = "%",
        progressCount = 2,
        detailTitle = "Analysis",
        detailBody = "Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra.",
        icon = MainIcon.Chart
    ),
    Feed(
        label = "Feed",
        title = "Feed",
        eyebrow = "Latest Update",
        metricTitle = "Momentum",
        metricValue = 12,
        metricUnit = "D",
        progressCount = 1,
        detailTitle = "Highlights",
        detailBody = "Curabitur sodales ligula in libero. Sed dignissim lacinia nunc. Curabitur tortor. Pellentesque nibh.",
        icon = MainIcon.List
    ),
    Profile(
        label = "Profile",
        title = "Profile",
        eyebrow = "User Status",
        metricTitle = "Consistency",
        metricValue = 91,
        metricUnit = "%",
        progressCount = 4,
        detailTitle = "Bio",
        detailBody = "Mauris ipsum. Nulla metus metus, ullamcorper vel, tincidunt sed, euismod in, nibh. Quisque volutpat.",
        icon = MainIcon.Profile
    );

    fun next(): MainDestination = entries[(ordinal + 1) % entries.size]
}
