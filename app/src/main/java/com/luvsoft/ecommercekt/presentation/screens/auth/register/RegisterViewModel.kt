package com.luvsoft.kotlinecommerce.presentation.screens.auth.register

import android.content.Context
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.luvsoft.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


enum class RegisterForm { NAME, APP, EMAIL, PHONE, PASSWORD, CONFIRM_PASSWORD }

@HiltViewModel
internal class RegisterViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : BaseViewModel() {
    var stateForm by mutableStateOf(RegisterState())
        private set

    var errorMesage by mutableStateOf("")
        private set

    fun onRegisterInput(value: String, registerField: RegisterForm) {
        stateForm = when (registerField) {
            RegisterForm.NAME -> stateForm.copy(name = value)
            RegisterForm.APP -> stateForm.copy(app = value)
            RegisterForm.EMAIL -> stateForm.copy(email = value)
            RegisterForm.PHONE -> stateForm.copy(phone = value)
            RegisterForm.PASSWORD -> stateForm.copy(password = value)
            RegisterForm.CONFIRM_PASSWORD ->
                stateForm.copy(confirmPassword = value)
        }
    }

    fun validateForm() = viewModelScope.launch {
        if (!Patterns.EMAIL_ADDRESS.matcher(stateForm.email).matches()) {
            errorMesage = "El email no es valido"
        } else if (stateForm.email.isEmpty()) {
            errorMesage = "El email no debe estar vacio"
        } else if (stateForm.password.length < 6) {
            errorMesage = "La contraseña debe tener al menos 6 caracteres"
        }

        delay(3000)
        errorMesage = ""
    }

    fun validateInput(): Boolean {
        errorMesage = when {
            stateForm.name.isBlank() ->
                "Ingresa tu nombre"

            stateForm.app.isBlank() ->
                "Ingresa tus apellidos"

            stateForm.email.isBlank() ->
                "Ingresa tu correo electrónico"

            stateForm.phone.isBlank() ->
                "Ingresa tu número de teléfono"

            stateForm.password.isBlank() ->
                "Ingresa una contraseña"

            stateForm.confirmPassword.isBlank() ->
                "Confirma tu contraseña"

            stateForm.password != stateForm.confirmPassword ->
                "Las contraseñas no coinciden"

            else -> ""
        }

        return errorMesage.isEmpty()
    }
}