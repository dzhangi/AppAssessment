package com.pk.appassessment.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val route: String
    val itemIcon: ImageVector?
}