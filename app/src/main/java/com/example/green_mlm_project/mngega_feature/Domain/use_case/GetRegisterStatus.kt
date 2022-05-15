package com.example.green_mlm_project.mngega_feature.Domain.use_case

import com.example.green_mlm_project.mngega_feature.Domain.model.RegisterResponse
import com.example.green_mlm_project.mngega_feature.data.repository.Repository

class GetRegisterStatus(private val repository: Repository) {

    suspend operator fun invoke(sponsorId:String, fname:String, lname:String, mail:String, contact:String, password:String ):RegisterResponse{
        return repository.register(sponsorId,fname,lname,mail,contact,password)
    }
}