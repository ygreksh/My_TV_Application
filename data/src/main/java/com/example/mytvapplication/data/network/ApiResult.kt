package com.example.mytvapplication.data.network

import kotlinx.serialization.Serializable

@Serializable
sealed interface ApiResult<out T> {
    data object Loading : ApiResult<Nothing>
    data class Success<out T>(val result: T) : ApiResult<T>
    data class ResponseError(val result: ErrorResponse) : ApiResult<Nothing>
    data object ConnectionError : ApiResult<Nothing>
}