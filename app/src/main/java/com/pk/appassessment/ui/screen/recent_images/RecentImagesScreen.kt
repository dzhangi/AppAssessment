package com.pk.appassessment.ui.screen.recent_images

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun RecentImagesScreen() {
    val viewModel: RecentImagesViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    Column {
        Button(onClick = { viewModel.fetchRecentImages() }) {
            Text(text = "Fetch Recent")
        }

        ImageGrid(imageUrls = uiState.urls)
    }
}

@Composable
fun LoadImage(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Photo"
    )
}

@Composable
fun ImageGrid(imageUrls: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(imageUrls) { imageUrl ->
            LoadImage(imageUrl = imageUrl)
        }
    }
}