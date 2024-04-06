package com.pk.appassessment.ui.screen.detailed_image

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.pk.appassessment.ui.util.recieveLinkNavHack
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailedImageViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailedImageUIState())
    val uiState = _uiState.asStateFlow()

    private val imageUrl: String =
        (checkNotNull(savedStateHandle["imageUrl"]) as String)
            .recieveLinkNavHack()

    init {
        upadateImageUrl(imageUrl)
    }

    fun upadateImageUrl(url: String) {
        Log.d("DetailedImageViewModel", "imageUrl: $url")
        if (imageUrl.isNotBlank()) _uiState.update { it.copy(imageUrl = url) }
    }
}