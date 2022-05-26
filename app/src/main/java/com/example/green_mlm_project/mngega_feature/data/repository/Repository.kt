package com.example.green_mlm_project.mngega_feature.data.repository

import com.example.green_mlm_project.mngega_feature.Domain.model.DashboardResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.LoginResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.RegisterResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.SponsorResponse
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun login(username:String,password:String):LoginResponse?
    suspend fun sponsorCheck(sponsorId:String):SponsorResponse
    suspend fun register(sponsorId: String,fname:String,lname:String,mail:String,contact:String,password: String):RegisterResponse
    suspend fun dashboard(primarkey:String):Flow<DashboardResponse>
}