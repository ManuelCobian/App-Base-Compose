package com.luvsoft.ecommercekt.di

import com.luvsoft.core.data.dataSource.remote.AuthRemoteDataSource
import com.luvsoft.core.data.dataSource.remote.AuthRemoteDataSourceImp
import com.luvsoft.core.data.dataSource.remote.services.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource =
        AuthRemoteDataSourceImp(authService)
}