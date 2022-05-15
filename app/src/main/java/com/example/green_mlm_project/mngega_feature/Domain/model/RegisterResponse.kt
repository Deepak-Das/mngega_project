package com.example.green_mlm_project.mngega_feature.Domain.model

data class RegisterResponse(
    val error: Boolean,
    val error_code: Int,
    val fullname: String,
    val login_id: String,
    val login_password: String,
    val message: String,
    val sponsor_id: String,
    val sponsor_name: String
)