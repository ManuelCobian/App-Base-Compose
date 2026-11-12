package com.luvsoft.core.domain.repositories

import com.luvsoft.core.domain.model.AuthResponse
import com.luvsoft.core.domain.utils.Resource


interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>;
}