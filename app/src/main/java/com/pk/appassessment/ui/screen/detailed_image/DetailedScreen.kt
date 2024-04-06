package com.pk.appassessment.ui.screen.detailed_image

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pk.appassessment.ui.component.LoadImage

@Composable
fun DetailedImageScreen() {
    val viewModel: DetailedImageViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    LoadImage(
        modifier = Modifier.fillMaxSize(),
        imageUrl = uiState.imageUrl
    )
}