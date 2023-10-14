package com.example.compositebuildsample.feature.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun ListScreenRoute() {
    ListScreen()
}

@Composable
fun ListScreen() {
    Text(text = "ListScreen")
}