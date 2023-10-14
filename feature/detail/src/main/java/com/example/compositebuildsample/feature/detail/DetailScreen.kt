package com.example.compositebuildsample.feature.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun DetailScreenRoute() {
    DetailScreen()
}

@Composable
fun DetailScreen() {
    Text(text = "DetailScreen")
}