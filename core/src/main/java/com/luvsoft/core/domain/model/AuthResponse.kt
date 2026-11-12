package com.luvsoft.core.domain.model

import com.google.gson.Gson

data class AuthResponse(
    val user: UserResponse,
    val token: String,
    val error: String? = null
){
    fun toJsonObject(): String = Gson().toJson(this)
    companion object AuthResponse {
        fun fromJsonObject(data: String): AuthResponse = Gson().fromJson(data, AuthResponse::class.java)
    }
}
