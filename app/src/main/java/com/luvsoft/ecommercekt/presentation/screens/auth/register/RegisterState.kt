package com.luvsoft.kotlinecommerce.presentation.screens.auth.register

data class RegisterState(
    val name: String = "",
    val app: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
