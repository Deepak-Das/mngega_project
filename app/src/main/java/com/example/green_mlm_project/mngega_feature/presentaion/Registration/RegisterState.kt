package com.example.green_mlm_project.mngega_feature.presentaion.Registration

import com.example.green_mlm_project.mngega_feature.Domain.model.SponsorResponse

data class RegisterState(
    val response: SponsorResponse? = null,
    val sponsorText: String = "",
    var referal: String = "",
    var spouse: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var contact: String = "",
    var email: String = "",
    var password: String = "",
    var waring:Boolean=false
)
