package com.pk.appassessment.ui.screen.recent_images

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.pk.appassessment.ui.component.LoadImage
import com.pk.appassessment.ui.util.sendLinkNavHack

@Composable
fun RecentImagesScreen(
    onItemClick: (String) -> Unit
) {
    val viewModel: RecentImagesViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    var columnsState by remember { mutableStateOf(2) }
    columnsState = resolveColumns(LocalConfiguration.current)

    var refreshState = rememberSwipeRefreshState(false)

    SwipeRefresh(
        state = refreshState,
        onRefresh = { viewModel.fetchRecentImages() }
    ) {
        ImageGrid(
            columns = columnsState,
            imageUrls = uiState.urls,
            onItemClick = { onItemClick(it.sendLinkNavHack()) }
        )
    }
}

@Composable
fun ImageGrid(
    columns: Int,
    imageUrls: List<String>,
    onItemClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = Modifier.padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(imageUrls) { imageUrl ->
            LoadImage(
                imageUrl = imageUrl,
                onClick = onItemClick,
                contentScale = ContentScale.Crop
            )
        }
    }
}

private fun resolveColumns(configuration: Configuration): Int {
    return when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> 4
        else -> 2
    }
}