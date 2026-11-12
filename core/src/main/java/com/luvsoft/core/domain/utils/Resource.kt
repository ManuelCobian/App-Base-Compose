package com.luvsoft.core.domain.utils

sealed class Resource<out T> {
    object Loading: Resource<Nothing>()
    data class Success<out T>(val data : T): Resource<T>()
    data class Failure<out T>(val message : Exception? = null): Resource<T>()
}