package com.example.green_mlm_project.mngega_feature.presentaion.login

import com.example.green_mlm_project.mngega_feature.Domain.model.LoginResponse

data class LoginState(
    val response: LoginResponse?=null,
    val username:String="",
    val password:String="",
    val warning:Boolean=false
)
