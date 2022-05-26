package com.example.green_mlm_project.mngega_feature.Domain.repository

import com.example.green_mlm_project.mngega_feature.Domain.model.DashboardResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.LoginResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.RegisterResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.SponsorResponse
import com.example.green_mlm_project.mngega_feature.data.data_soruce.ApiService
import com.example.green_mlm_project.mngega_feature.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiService: ApiService
) : Repository {
    override suspend fun login(username: String, password: String): LoginResponse? {
        return apiService.login(username, password)
    }

    override suspend fun sponsorCheck(sponsorId:String): SponsorResponse {
        return apiService.sponsorResponse(sponsorId)
    }

    override suspend fun register(
        sponsorId: String,
        fname: String,
        lname: String,
        mail: String,
        contact: String,
        password: String
    ): RegisterResponse {
        return apiService.registerResponse(sponsorId,fname,lname,mail,contact,password)
    }

    override suspend fun dashboard(primarkey: String): Flow<DashboardResponse> {
         return apiService.dashboardResponse(primarkey)
//        return response
    }
}