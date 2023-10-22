package com.example.compositebuildsample.feature.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compositebuildsample.core.domain.usecase.GetMemoByIdUseCase
import com.example.compositebuildsample.feature.detail.navigation.MEMO_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMemoByIdUseCase: GetMemoByIdUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    init {
        savedStateHandle.getLiveData<String>(MEMO_ID).observeForever {
            getMemoById(it)
        }
    }

    private fun getMemoById(memoId: String) {
        getMemoByIdUseCase.invoke(memoId.toInt()).onEach { memo ->
            _uiState.update {
                it.copy(memo = memo)
            }
        }.launchIn(viewModelScope)
    }
}
