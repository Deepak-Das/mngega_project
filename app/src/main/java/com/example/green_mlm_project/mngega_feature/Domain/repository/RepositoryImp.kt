package com.example.green_mlm_project.mngega_feature.Domain.repository

import com.example.green_mlm_project.mngega_feature.Domain.model.LoginResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.SponsorResponse
import com.example.green_mlm_project.mngega_feature.data.data_soruce.ApiService
import com.example.green_mlm_project.mngega_feature.data.repository.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiService: ApiService
) : Repository {
    override suspend fun login(username: String, password: String): LoginResponse {
        return apiService.login(username, password)
    }

    override suspend fun sponsorCheck(sponsorId:String): SponsorResponse {
        return apiService.sponsorResponse(sponsorId)
    }
}