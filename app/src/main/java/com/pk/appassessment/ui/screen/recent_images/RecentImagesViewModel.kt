package com.pk.appassessment.ui.screen.recent_images

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pk.appassessment.data.remote.RecentImagesApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentImagesViewModel @Inject constructor(
    private val recentImagesApi: RecentImagesApi
) : ViewModel() {

    fun fetchRecentImages() {
        viewModelScope.launch(Dispatchers.IO) {
            recentImagesApi.getRecentPhotos()
        }
    }
}