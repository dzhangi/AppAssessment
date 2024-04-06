package com.pk.appassessment.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pk.appassessment.ui.component.BottomNabBar
import com.pk.appassessment.ui.navigation.AppAssessmentHavHost
import com.pk.appassessment.ui.navigation.RecentImages
import com.pk.appassessment.ui.navigation.bottomNavItems
import com.pk.appassessment.ui.navigation.navigateSingleTopTo
import com.pk.appassessment.ui.theme.AppAssessmentTheme

@Composable
fun MainScreen() {
    AppAssessmentTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = bottomNavItems.find { destination ->
            destination.route == currentDestination?.route
        } ?: RecentImages

        Scaffold(
            topBar = { },
            content = { AppAssessmentHavHost(navController, Modifier.padding(it)) },
            floatingActionButton = {},
            bottomBar = {
                BottomNabBar(
                    allScreens = bottomNavItems,
                    onTabSelected = { destination ->
                        navController.navigateSingleTopTo(destination.route)
                    },
                    currentScreen = currentScreen
                )
            }
        )
    }
}