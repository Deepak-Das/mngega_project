package com.example.green_mlm_project.mngega_feature.Domain.use_case

import com.example.green_mlm_project.mngega_feature.Domain.model.LoginResponse
import com.example.green_mlm_project.mngega_feature.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLoginStatus @Inject constructor(private  val repository: Repository) {

    private var getNotesJob: Job? = null

    suspend operator fun invoke(username:String, password:String):LoginResponse{

        return repository.login(username = username,password = password)


    }
}