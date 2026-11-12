package com.luvsoft.core.data.repository

import com.luvsoft.core.data.dataSource.remote.AuthRemoteDataSource
import com.luvsoft.core.domain.model.AuthResponse
import com.luvsoft.core.domain.repositories.AuthRepository
import com.luvsoft.core.domain.utils.Resource
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Resource<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            Resource.Success(result.body()!!)

        }catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}