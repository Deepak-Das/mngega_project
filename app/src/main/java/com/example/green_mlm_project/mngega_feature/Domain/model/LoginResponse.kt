package com.example.green_mlm_project.mngega_feature.Domain.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("error")
    val error: Boolean,
    val error_code: Int,
    val fullname: String,
    val message: String,
    val primary_id: String,
    val userid: String
)