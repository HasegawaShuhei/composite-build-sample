package com.example.compositebuildsample.feature.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun DetailScreenRoute(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState(DetailUiState())
    DetailScreen(uiState = uiState)
}

@Composable
fun DetailScreen(
    uiState: DetailUiState,
) {
    if (uiState.memo == null) {
        return Text("loading")
    }
    Text(text = uiState.memo.title)
}