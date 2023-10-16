package com.example.compositebuildsample.core.domain.usecase

import com.example.compositebuildsample.core.domain.repository.MemoRepository
import com.example.compositebuildsample.core.model.Memo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMemosUseCase @Inject constructor(
    private val memoRepository: MemoRepository,
) {
      operator fun invoke(): Flow<List<Memo>> = memoRepository.getMemos()
}