package com.luvsoft.ecommercekt.di

import com.luvsoft.core.data.dataSource.remote.AuthRemoteDataSource
import com.luvsoft.core.data.repository.AuthRepositoryImp
import com.luvsoft.core.domain.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository =
        AuthRepositoryImp(authRemoteDataSource)
}