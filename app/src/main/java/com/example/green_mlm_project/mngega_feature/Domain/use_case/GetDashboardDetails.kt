package com.example.green_mlm_project.mngega_feature.Domain.use_case

import com.example.green_mlm_project.mngega_feature.Domain.model.DashboardResponse
import com.example.green_mlm_project.mngega_feature.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class GetDashboardDetails @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(primaryKey:String):Flow<DashboardResponse> {
        return repository.dashboard(primaryKey)

    }
}