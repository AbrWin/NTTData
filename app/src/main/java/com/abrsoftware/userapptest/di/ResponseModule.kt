package com.abrsoftware.userapptest.di

import com.abrsoftware.userapptest.data.repository.ResponseRepositoryImpl
import com.abrsoftware.userapptest.domain.repository.ResponceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ResponseModule {

    @Binds
    @Singleton
    abstract fun bindApiRepository(
        repositoryImpl: ResponseRepositoryImpl
    ): ResponceRepository
}