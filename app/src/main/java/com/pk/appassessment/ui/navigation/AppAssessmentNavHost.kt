package com.pk.appassessment.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            RecentImagesScreen(
                onItemClick = { imageUrl ->
                    Log.d("NAV_HOST", "Image URL: $it")
                    navController.navigate("${Detailed.route}/${imageUrl}")
                }
            )
        }
        composable(
            route = "${Detailed.route}/{imageUrl}",
            arguments = listOf(navArgument("imageUrl") { type = NavType.StringType })
        ) {
            DetailedImageScreen()
        }
    }
}