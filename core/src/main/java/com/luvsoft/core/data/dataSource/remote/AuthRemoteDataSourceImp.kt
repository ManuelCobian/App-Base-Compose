package com.luvsoft.core.data.dataSource.remote

import com.luvsoft.core.data.dataSource.remote.services.AuthService
import com.luvsoft.core.domain.model.AuthResponse
import com.luvsoft.core.domain.model.LoginRequest
import retrofit2.Response
import javax.inject.Inject

// esto es como los repositorios que se utilizaban anteriormente
class AuthRemoteDataSourceImp @Inject constructor(private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun login(
        email: String,
        password: String
    ): Response<AuthResponse> = authService.login(LoginRequest(email, password))
}