package com.pk.appassessment.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material.icons.sharp.List
import androidx.compose.ui.graphics.vector.ImageVector

object RecentImages : Destination {
    override val route: String = Route.RECENT_IMAGES.name
    override val itemIcon: ImageVector = Icons.Sharp.List
}

object Detailed : Destination {
    override val route: String = Route.DETAILED_IMAGE.name
    override val itemIcon: ImageVector = Icons.Sharp.AccountBox
}

val bottomNavItems = listOf(RecentImages, Detailed)