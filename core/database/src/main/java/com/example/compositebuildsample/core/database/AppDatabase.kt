package com.example.compositebuildsample.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.compositebuildsample.core.database.dao.MemoDao
import com.example.compositebuildsample.core.database.model.MemoEntity

@Database(entities = [MemoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}