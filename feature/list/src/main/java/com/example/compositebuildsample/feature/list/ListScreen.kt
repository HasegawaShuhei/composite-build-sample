package com.example.compositebuildsample.feature.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compositebuildsample.feature.detail.navigation.navigateToDetail

@Composable
internal fun ListScreenRoute(
    navController: NavController,
    viewModel: ListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState(ListUiState())
    ListScreen(
        navController = navController,
        uiState = uiState,
        upsertMemo = viewModel::upsertMemo,
        setTitle = viewModel::setTitle,
        setDescription = viewModel::setDescription,
        setDialogVisibility = viewModel::setDialogVisibility,
    )
}

@Composable
fun ListScreen(
    navController: NavController,
    uiState: ListUiState,
    upsertMemo: () -> Unit,
    setTitle: (String) -> Unit,
    setDescription: (String) -> Unit,
    setDialogVisibility: (Boolean) -> Unit,
) {
    if (uiState.isVisibleDialog) {
        UpsertDialog(
            setDialogVisibility = setDialogVisibility,
            upsertMemo = upsertMemo,
            title = uiState.title,
            description = uiState.description,
            setTitle = setTitle,
            setDescription = setDescription,
        )
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { setDialogVisibility(true) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "新規作成")
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "ListScreen")
            Button(onClick = {
                navController.navigateToDetail()
            }) {
                Text(text = "to detailScreen")
            }
        }
    }
}

@Composable
fun UpsertDialog(
    setDialogVisibility: (Boolean) -> Unit,
    upsertMemo: () -> Unit,
    title: String,
    description: String,
    setTitle: (String) -> Unit,
    setDescription: (String) -> Unit,
) {
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