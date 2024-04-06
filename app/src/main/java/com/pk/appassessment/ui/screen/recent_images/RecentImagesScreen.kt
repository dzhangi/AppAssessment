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
import com.pk.appassessment.ui.component.LoadImage
import com.pk.appassessment.ui.util.sendLinkNavHack

@Composable
fun RecentImagesScreen(
    onItemClick: (String) -> Unit
) {
    val viewModel: RecentImagesViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    Column {
        Button(onClick = { viewModel.fetchRecentImages() }) {
            Text(text = "Fetch Recent")
        }

        ImageGrid(
            imageUrls = uiState.urls,
            onItemClick = { onItemClick(it.sendLinkNavHack()) }
        )
    }
}

@Composable
fun ImageGrid(
    imageUrls: List<String>,
    onItemClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(imageUrls) { imageUrl ->
            LoadImage(imageUrl = imageUrl, onClick = onItemClick)
        }
    }
}