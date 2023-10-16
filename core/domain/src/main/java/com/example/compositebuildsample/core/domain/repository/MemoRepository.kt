package com.example.compositebuildsample.core.domain.repository

import com.example.compositebuildsample.core.model.Memo
import kotlinx.coroutines.flow.Flow

interface MemoRepository {
    fun getMemos(): Flow<List<Memo>>

    suspend fun upsert(memo: Memo)

    suspend fun delete(memo: Memo)

}