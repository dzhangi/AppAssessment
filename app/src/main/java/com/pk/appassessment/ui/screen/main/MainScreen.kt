package com.pk.appassessment.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.pk.appassessment.ui.navigation.AppAssessmentHavHost
import com.pk.appassessment.ui.theme.AppAssessmentTheme

@Composable
fun MainScreen() {
    AppAssessmentTheme {
        val navController = rememberNavController()

        Scaffold(
            content = { AppAssessmentHavHost(navController, Modifier.padding(it)) },
        )
    }
}