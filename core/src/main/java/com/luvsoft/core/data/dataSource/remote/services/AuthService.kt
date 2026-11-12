package com.luvsoft.core.data.dataSource.remote.services

import com.luvsoft.core.domain.model.AuthResponse
import com.luvsoft.core.domain.model.LoginRequest
import com.luvsoft.core.domain.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<AuthResponse>
}