package com.example.compositebuildsample.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.compositebuildsample.core.model.Memo

@Entity(tableName = "memos")
data class MemoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
)

fun MemoEntity.asExternalModel() = Memo(
    id = id,
    title = title,
    description = description,
)