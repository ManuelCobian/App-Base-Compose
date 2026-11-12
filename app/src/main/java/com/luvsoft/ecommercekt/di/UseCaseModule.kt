package com.luvsoft.ecommercekt.di

import com.luvsoft.core.data.dataSource.remote.AuthRemoteDataSource
import com.luvsoft.core.data.repository.AuthRepositoryImp
import com.luvsoft.core.domain.repositories.AuthRepository
import com.luvsoft.core.domain.usecase.auth.AuthUseCase
import com.luvsoft.core.domain.usecase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        loginUseCase = LoginUseCase(authRepository)
    )
}