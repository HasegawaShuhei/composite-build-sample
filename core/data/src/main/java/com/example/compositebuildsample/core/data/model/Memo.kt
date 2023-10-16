package com.example.compositebuildsample.core.data.model

import com.example.compositebuildsample.core.database.model.MemoEntity
import com.example.compositebuildsample.core.model.Memo

fun Memo.asEntity() = MemoEntity(
    id = id,
    title = title,
    description = description,
)