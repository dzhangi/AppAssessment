package com.pk.appassessment.domain.repo

import com.pk.appassessment.domain.model.PhotoInfo

interface RecentImagesRepo {

    suspend fun getRecentImages(): List<PhotoInfo>
}