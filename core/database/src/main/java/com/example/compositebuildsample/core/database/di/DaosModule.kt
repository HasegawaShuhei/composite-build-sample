package com.example.compositebuildsample.core.database.di

import com.example.compositebuildsample.core.database.AppDatabase
import com.example.compositebuildsample.core.database.dao.MemoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    @Singleton
    fun provideMemoDao(db: AppDatabase): MemoDao = db.memoDao()
}