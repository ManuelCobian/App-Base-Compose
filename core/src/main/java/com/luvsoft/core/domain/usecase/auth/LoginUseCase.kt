package com.luvsoft.core.domain.usecase.auth

import com.luvsoft.core.data.dataSource.remote.services.AuthService
import com.luvsoft.core.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginUseCase  @Inject constructor(private val repository: AuthRepository) {
    suspend operator  fun invoke(email: String, password: String) = repository.login(email,password)
}