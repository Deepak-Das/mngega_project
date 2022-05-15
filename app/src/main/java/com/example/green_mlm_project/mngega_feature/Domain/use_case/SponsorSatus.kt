package com.example.green_mlm_project.mngega_feature.Domain.use_case

import com.example.green_mlm_project.mngega_feature.Domain.model.SponsorResponse
import com.example.green_mlm_project.mngega_feature.data.repository.Repository
import javax.inject.Inject

class SponsorSatus @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sponserId:String):SponsorResponse{
       return repository.sponsorCheck(sponserId)
    }
}