package com.example.compositebuildsample.feature.list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compositebuildsample.core.model.Memo

@Composable
fun MemoListItem(
    memo: Memo,
    onDelete: (Memo) -> Unit,
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = memo.title,
                        fontWeight = FontWeight.Bold
                    )
                    if (memo.description.isNotEmpty()) {
                        Text(text = memo.description)
                    }
                }
            }
            Row {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Edit, contentDescription = "編集")
                }
                IconButton(onClick = { onDelete(memo) }) {
                    Icon(Icons.Default.Delete, contentDescription = "削除")
                }
            }
        }
    }
}

@Preview
@Composable
fun MemoListItemPreview() {
    val memo = Memo(
        id = 0,
        title = "title",
        description = "description"
    )
    MemoListItem(
        memo = memo,
        onDelete = {}
    )
}