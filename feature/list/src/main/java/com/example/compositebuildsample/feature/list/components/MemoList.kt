package com.example.compositebuildsample.feature.list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compositebuildsample.core.model.Memo

@Composable
fun MemoList(
    memos: List<Memo>,
    onDelete: (Memo) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(all = 4.dp)
    ) {
        items(
            count = memos.size,
        ) {
            MemoListItem(
                memo = memos[it],
                onDelete = onDelete,
            )
        }
    }
}