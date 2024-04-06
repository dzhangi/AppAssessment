package com.pk.appassessment.data.repo

import com.pk.appassessment.data.remote.RecentImagesApi
import com.pk.appassessment.data.remote.model.toPhotoInfo
import com.pk.appassessment.domain.model.PhotoInfo
import com.pk.appassessment.domain.repo.RecentImagesRepo
import javax.inject.Inject

class RecentImagesRepository @Inject constructor(
    private val recentImagesApi: RecentImagesApi
) : RecentImagesRepo {
    override suspend fun getRecentImages(): List<PhotoInfo> {
        return recentImagesApi.getRecentPhotos().photos.photo
            .map { it.toPhotoInfo() }
    }
}