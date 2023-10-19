package com.example.compositebuildsample.feature.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compositebuildsample.core.model.Memo
import com.example.compositebuildsample.feature.list.components.MemoList
import com.example.compositebuildsample.feature.list.components.UpsertDialog

@Composable
internal fun ListScreenRoute(
    navController: NavController,
    viewModel: ListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState(ListUiState())
    ListScreen(
        navController = navController,
        uiState = uiState,
        setMemo = viewModel::setMemo,
        upsertMemo = viewModel::upsertMemo,
        onDelete = viewModel::deleteMemo,
        setTitle = viewModel::setTitle,
        setDescription = viewModel::setDescription,
        setDialogVisibility = viewModel::setDialogVisibility,
        clearProperties = viewModel::clearProperties,
        isEditing = viewModel.isEditing,
    )
}

@Composable
fun ListScreen(
    navController: NavController,
    uiState: ListUiState,
    setMemo: (Memo) -> Unit,
    upsertMemo: () -> Unit,
    onDelete: (Memo) -> Unit,
    setTitle: (String) -> Unit,
    setDescription: (String) -> Unit,
    setDialogVisibility: (Boolean) -> Unit,
    clearProperties: () -> Unit,
    isEditing: Boolean,
) {
    if (uiState.isVisibleDialog) {
        UpsertDialog(
            setDialogVisibility = setDialogVisibility,
            upsertMemo = upsertMemo,
            title = uiState.title,
            description = uiState.description,
            setTitle = setTitle,
            setDescription = setDescription,
            clearProperties = clearProperties,
            isEditing = isEditing,
        )
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { setDialogVisibility(true) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "新規作成")
            }
        }
    ) {
        MemoList(
            memos = uiState.memos,
            onTapEdit = { it ->
                setMemo(it)
                setDialogVisibility(true)
            },
            onDelete = onDelete,
            modifier = Modifier.padding(it)
        )
    }
}

