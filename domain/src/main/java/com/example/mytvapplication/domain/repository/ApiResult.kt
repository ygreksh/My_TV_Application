package com.example.mytvapplication.domain.repository

//@Serializable
sealed interface ApiResult<out T> {
    data object Loading : ApiResult<Nothing>
    data class Success<out T>(val result: T) : ApiResult<T>
    data class Error(val exception: Exception) : ApiResult<Nothing>
//    data class ResponseError(val result: ErrorResponse) : ApiResult<Nothing>
//    data object ConnectionError : ApiResult<Nothing>
}