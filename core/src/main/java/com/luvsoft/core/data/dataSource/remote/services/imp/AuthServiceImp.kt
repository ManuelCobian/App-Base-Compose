package com.luvsoft.core.data.dataSource.remote.services.imp

import com.luvsoft.core.data.dataSource.remote.services.AuthService
import com.luvsoft.core.domain.model.AuthResponse
import com.luvsoft.core.domain.model.LoginRequest
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class AuthServiceImp @Inject constructor(private val retrofit: Retrofit) : AuthService  {
    val serviceAuth = retrofit.create(AuthService::class.java)

    override suspend fun login(loginRequest: LoginRequest): Response<AuthResponse> {
        return serviceAuth.login(loginRequest)
    }
}