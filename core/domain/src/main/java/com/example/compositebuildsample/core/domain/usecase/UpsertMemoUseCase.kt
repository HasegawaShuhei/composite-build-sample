package com.example.compositebuildsample.core.domain.usecase

import com.example.compositebuildsample.core.domain.repository.MemoRepository
import com.example.compositebuildsample.core.model.Memo
import javax.inject.Inject

class UpsertMemoUseCase @Inject constructor(
    private val memoRepository: MemoRepository,
) {
    suspend operator fun invoke(memo: Memo) = memoRepository.upsert(memo)
}