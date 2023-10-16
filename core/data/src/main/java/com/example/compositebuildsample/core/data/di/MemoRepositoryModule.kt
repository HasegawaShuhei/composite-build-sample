package com.example.compositebuildsample.core.data.di

import com.example.compositebuildsample.core.data.repository.MemoRepositoryImpl
import com.example.compositebuildsample.core.database.dao.MemoDao
import com.example.compositebuildsample.core.domain.repository.MemoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MemoRepositoryModule {

    @Provides
    @Singleton
    fun provideMemoRepository(memoDao: MemoDao): MemoRepository {
        return MemoRepositoryImpl(memoDao)
    }
}