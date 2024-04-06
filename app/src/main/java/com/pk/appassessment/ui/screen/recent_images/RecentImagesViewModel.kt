package com.pk.appassessment.ui.screen.recent_images

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pk.appassessment.domain.GetRecentImageUrlsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentImagesViewModel @Inject constructor(
    private val getRecentImageUrls: GetRecentImageUrlsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecentImagesUIState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchRecentImages()
    }

    fun fetchRecentImages() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching { getRecentImageUrls() }
                .onSuccess { urls ->
                    Log.d("RecentImagesViewModel", "size: ${urls.size} \nurls: $urls")
                    _uiState.update { it.copy(urls = urls) }
                }
                .onFailure { Log.e("RecentImagesViewModel", "fetchRecentImages: ", it) }
        }
    }
}