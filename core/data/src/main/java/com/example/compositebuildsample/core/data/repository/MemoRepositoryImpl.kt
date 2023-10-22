package com.example.compositebuildsample.core.data.repository

import com.example.compositebuildsample.core.data.model.asEntity
import com.example.compositebuildsample.core.database.dao.MemoDao
import com.example.compositebuildsample.core.database.model.MemoEntity
import com.example.compositebuildsample.core.database.model.asExternalModel
import com.example.compositebuildsample.core.domain.repository.MemoRepository
import com.example.compositebuildsample.core.model.Memo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor(
    private val memoDao: MemoDao,
) : MemoRepository {
    override fun getMemos(): Flow<List<Memo>> {
        return memoDao.getMemos().map {
            it.map(MemoEntity::asExternalModel)
        }
    }

    override fun getMemoById(id: Int): Flow<Memo> {
        return memoDao.getMemoById(id).map { it.asExternalModel() }
    }

    override suspend fun upsert(memo: Memo) {
        memoDao.upsert(memo.asEntity())
    }

    override suspend fun delete(memo: Memo) {
        memoDao.delete(memo.asEntity())
    }
}