package com.luvsoft.core.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id") val id: Long? = 0,
    @SerializedName("name") val name: String? = "",
    @SerializedName("email") val email: String? = "",
    @SerializedName("lastname") val lastname: String? = "",
    @SerializedName("password") val password: String? = "",
    @SerializedName("phone") val phone: String? = "",
    @SerializedName("image") val image: String? = null,
    @SerializedName("notification_token") val notificationToken: String? = "",
){
    fun toJsonObject(): String = Gson().toJson(this)
    companion object {
        fun fromJsonObject(data: String): UserResponse = Gson().fromJson(data, UserResponse::class.java)
    }
}
