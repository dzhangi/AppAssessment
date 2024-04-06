package com.pk.appassessment.ui.screen.detailed_image

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.pk.appassessment.ui.component.LoadImage

@Composable
fun DetailedImageScreen() {
    val viewModel: DetailedImageViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    LoadImage(imageUrl = uiState.imageUrl)
}