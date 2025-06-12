package com.example.mytvapplication.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    @SerialName("non_field_errors")
    val fields: String? = null
)