package com.luvsoft.ecommercekt.presentation.screens.auth.login

import android.content.Context
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.luvsoft.base.viewmodel.BaseViewModel
import com.luvsoft.core.domain.model.AuthResponse
import com.luvsoft.core.domain.usecase.auth.AuthUseCase
import com.luvsoft.core.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class LoginViewmodel @Inject constructor(
    private val authUseCase: AuthUseCase,
    @ApplicationContext private val context: Context,
) : BaseViewModel() {
    var stateForm by mutableStateOf(LoginState())
    private set

    var errorMesage by mutableStateOf("")


    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)

    fun onEmailInput(email: String) {
        stateForm = stateForm.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        stateForm = stateForm.copy(password = password)
    }

    fun isValidateForm(): Boolean {

        if (!Patterns.EMAIL_ADDRESS.matcher(stateForm.email).matches()) {
            errorMesage = "El email no es valido"
            return false
        } else if (stateForm.email.isEmpty()) {
            errorMesage = "El email no debe estar vacio"
            return false
        } else if (stateForm.password.length < 6) {
            errorMesage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }

        return true;
    }

    fun login() = viewModelScope.launch {
        if (isValidateForm()) {
            loginResponse = Resource.Loading
            val result = authUseCase.loginUseCase(
                stateForm.email,
                stateForm.password
            )
           loginResponse = result
        }
    }
}