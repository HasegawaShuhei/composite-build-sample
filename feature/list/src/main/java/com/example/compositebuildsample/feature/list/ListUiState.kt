package com.example.compositebuildsample.feature.list

import com.example.compositebuildsample.core.model.Memo

data class ListUiState(
    val memos: List<Memo> = emptyList(),
    val isVisibleDialog: Boolean = false,
    val title: String = "",
    val description: String = "",
)
