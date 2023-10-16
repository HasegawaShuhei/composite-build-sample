package com.example.compositebuildsample.core.data.repository

import com.example.compositebuildsample.core.domain.repository.MemoRepository
import com.example.compositebuildsample.core.model.Memo
import kotlinx.coroutines.flow.Flow

class MemoRepositoryImpl : MemoRepository {
    override fun getMemos(): Flow<List<Memo>> {
        TODO("Not yet implemented")
    }

    override suspend fun upsert(memo: Memo) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(memo: Memo) {
        TODO("Not yet implemented")
    }
}