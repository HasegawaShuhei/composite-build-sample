package com.example.compositebuildsample.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compositebuildsample.core.domain.usecase.DeleteMemoUseCase
import com.example.compositebuildsample.core.domain.usecase.GetMemosUseCase
import com.example.compositebuildsample.core.domain.usecase.UpsertMemoUseCase
import com.example.compositebuildsample.core.model.Memo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getMemosUseCase: GetMemosUseCase,
    private val upsertUseCase: UpsertMemoUseCase,
    private val deleteMemoUseCase: DeleteMemoUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ListUiState())
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    private val value: ListUiState
        get() = _uiState.value
    val isEditing: Boolean
        get() = value.editingMemo != null

    init {
        getMemos()
    }

    fun upsertMemo() {
        val memo = if (isEditing) {
            Memo(
                id = value.editingMemo!!.id,
                title = value.title,
                description = value.description,
            )
        } else {
            Memo(
                id = null,
                title = value.title,
                description = value.description
            )
        }
        viewModelScope.launch {
            upsertUseCase.invoke(memo)
        }
    }

    fun deleteMemo(memo: Memo) {
        viewModelScope.launch {
            deleteMemoUseCase.invoke(memo)
        }
    }

    fun setMemo(memo: Memo) {
        _uiState.update {
            it.copy(
                editingMemo = memo,
                title = memo.title,
                description = memo.description,
            )
        }
    }

    fun setTitle(title: String) {
        _uiState.update {
            it.copy(title = title)
        }
    }

    fun setDescription(description: String) {
        _uiState.update {
            it.copy(description = description)
        }
    }

    fun setDialogVisibility(isVisible: Boolean) {
        _uiState.update {
            it.copy(isVisibleDialog = isVisible)
        }
    }

    fun clearProperties() {
        _uiState.update {
            it.copy(
                editingMemo = null,
                title = "",
                description = "",
            )
        }
    }

    private fun getMemos() {
        getMemosUseCase().onEach { memos ->
            _uiState.update { state ->
                state.copy(
                    memos = memos
                )
            }
        }.launchIn(viewModelScope)
    }

}
