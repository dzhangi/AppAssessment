package com.pk.appassessment.ui.screen.recent_images

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RecentImagesScreen() {
    val viewModel: RecentImagesViewModel = hiltViewModel()

    Column {
        Text(text = "Recent Images")
        Button(onClick = { viewModel.fetchRecentImages() }) {
            Text(text = "Fetch Recent")
        }
    }
}