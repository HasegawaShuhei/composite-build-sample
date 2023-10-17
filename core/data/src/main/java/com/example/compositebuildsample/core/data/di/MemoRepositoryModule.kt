package com.example.compositebuildsample.core.data.di

import com.example.compositebuildsample.core.data.repository.MemoRepositoryImpl
import com.example.compositebuildsample.core.domain.repository.MemoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MemoRepositoryModule {

    @Binds
    fun bindsMemoRepository(memoRepository: MemoRepositoryImpl): MemoRepository
}

//@Module
//@InstallIn(SingletonComponent::class)
//object MemoRepositoryModule {
//
//    @Provides
//    @Singleton
//    fun provideMemoRepository(memoDao: MemoDao): MemoRepository {
//        return MemoRepositoryImpl(memoDao)
//    }
//}