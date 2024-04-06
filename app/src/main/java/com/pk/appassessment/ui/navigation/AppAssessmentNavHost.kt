package com.pk.appassessment.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pk.appassessment.ui.screen.detailed_image.DetailedImageScreen
import com.pk.appassessment.ui.screen.recent_images.RecentImagesScreen


@Composable
fun AppAssessmentHavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = RecentImages.route,
        modifier = modifier
    ) {
        composable(RecentImages.route) {
            RecentImagesScreen()
        }
        composable(Detailed.route) {
            DetailedImageScreen()
        }
    }
}