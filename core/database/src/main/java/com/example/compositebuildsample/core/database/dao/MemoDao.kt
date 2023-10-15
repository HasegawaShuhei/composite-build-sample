package com.example.compositebuildsample.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.compositebuildsample.core.database.model.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(memo: MemoEntity)

    @Delete
    suspend fun delete(memo: MemoEntity)

    @Query("SELECT * FROM memos")
    fun getMemos(): Flow<List<MemoEntity>>
}