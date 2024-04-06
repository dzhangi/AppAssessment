package com.pk.appassessment.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun LoadImage(
    imageUrl: String,
    onClick: (String) -> Unit = {}
) {
    AsyncImage(
        modifier = Modifier.clickable { onClick(imageUrl) },
        model = imageUrl,
        contentDescription = "Photo"
    )
}