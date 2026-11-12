package com.luvsoft.core.data.dataSource.remote

import com.luvsoft.core.domain.model.AuthResponse
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): Response<AuthResponse>;
}