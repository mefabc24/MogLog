package com.leet.moglog.submission01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leet.moglog.ui.theme.MogLogTheme

private enum class SubmissionPage(
    val label: String,
    val title: String,
    val body: String
) {
    Home(
        label = "Home",
        title = "Home",
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    ),
    Discover(
        label = "Discover",
        title = "Discover",
        body = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
    ),
    Create(
        label = "Create",
        title = "Create",
        body = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
    ),
    Stats(
        label = "Stats",
        title = "Stats",
        body = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    ),
    Profile(
        label = "Profile",
        title = "Profile",
        body = "Curabitur pretium tincidunt lacus. Nulla gravida orci a odio, nullam varius, turpis et commodo pharetra."
    )
}

@Composable
fun Submission01Screen(modifier: Modifier = Modifier) {
    var selectedPageName by rememberSaveable { mutableStateOf(SubmissionPage.Home.name) }
    val selectedPage = SubmissionPage.valueOf(selectedPageName)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                SubmissionPage.entries.forEach { page ->
                    NavigationBarItem(
                        selected = page == selectedPage,
                        onClick = { selectedPageName = page.name },
                        icon = { Text(page.label.take(1)) },
                        label = { Text(page.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        SubmissionPageContent(
            page = selectedPage,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun SubmissionPageContent(
    page: SubmissionPage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = page.title,
            style = MaterialTheme.typography.headlineMedium
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Page Content",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = page.body,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam.",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Submission01ScreenPreview() {
    MogLogTheme {
        Submission01Screen()
    }
}
