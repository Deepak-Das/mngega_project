package com.example.green_mlm_project.mngega_feature.presentaion.Registration

import com.example.green_mlm_project.mngega_feature.Domain.model.RegisterResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.SponsorResponse

data class RegisterState(
    val sponsor_response: SponsorResponse? = null,
    val registor_response: RegisterResponse? = null,
    val sponsorText: String = "",
    var sponsorId: String = "",
    var spouse: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var contact: String = "",
    var email: String = "",
    var password: String = "",
    var waring:Boolean=false,
    var registerStatus:Boolean=false,
    var registerText:String="",
    var connection:Boolean=false
)
