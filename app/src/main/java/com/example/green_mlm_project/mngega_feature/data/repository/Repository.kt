package com.example.green_mlm_project.mngega_feature.data.repository

import com.example.green_mlm_project.mngega_feature.Domain.model.LoginResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.SponsorResponse

interface Repository {

    suspend fun login(username:String,password:String):LoginResponse
    suspend fun sponsorCheck(sponsorId:String):SponsorResponse
}