package com.luvsoft.ecommercekt.di

import com.luvsoft.core.data.dataSource.remote.services.AuthService
import com.luvsoft.core.data.dataSource.remote.services.imp.AuthServiceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class HitModuleService {
    @Singleton
    @Binds
    abstract fun bindHitService(imp: AuthServiceImp): AuthService
}