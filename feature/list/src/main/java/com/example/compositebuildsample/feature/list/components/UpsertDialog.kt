package com.example.compositebuildsample.feature.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UpsertDialog(
    setDialogVisibility: (Boolean) -> Unit,
    upsertMemo: () -> Unit,
    title: String,
    description: String,
    setTitle: (String) -> Unit,
    setDescription: (String) -> Unit,
    clearProperties: () -> Unit,
) {
    DisposableEffect(Unit) {
        onDispose {
            clearProperties()
        }
    }
    AlertDialog(
        onDismissRequest = { setDialogVisibility(false) },
        confirmButton = {
            TextButton(onClick = {
                upsertMemo()
                setDialogVisibility(false)
            }) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            TextButton(onClick = { setDialogVisibility(false) }) {
                Text(text = "キャンセル")
            }
        },
        title = {
            Text("新規作成")
        },
        text = {
            Column {
                Text("タイトル")
                TextField(value = title, onValueChange = { setTitle(it) })
                Spacer(modifier = Modifier.height(8.dp))
                Text("説明")
                TextField(value = description, onValueChange = { setDescription(it) })
            }
        },
    )
}