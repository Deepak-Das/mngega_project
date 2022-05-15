package com.example.green_mlm_project.mngega_feature.data.data_soruce

import com.example.green_mlm_project.mngega_feature.Domain.model.LoginResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.RegisterResponse
import com.example.green_mlm_project.mngega_feature.Domain.model.SponsorResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow

class ApiService {

    val client= HttpClient(Android){
        install(DefaultRequest){
            headers.append("Content-Type","application/json")
        }
        install(JsonFeature){
            serializer =GsonSerializer()
        }
        engine {
            connectTimeout=100_00
            socketTimeout=100_00
        }
    }

    suspend fun login(username:String,password:String):LoginResponse{
        return client.get {
            url("https://api.greenworld.in.net/login.php?usersid=${username}&password=${password}")
        }
    }
    suspend fun sponsorResponse(sponsorId:String):SponsorResponse{
        return client.get {
            url("https://api.greenworld.in.net/register.php?sponserid=${sponsorId}")
        }
    }
    suspend fun registerResponse(sponsorId: String,fname:String,lname:String,mail:String,contact:String,password: String):RegisterResponse{
        return client.post {
            url("https://api.greenworld.in.net/register.php?sponserid=${sponsorId}&fname=${fname}&lname=${lname}&mail=${mail}&contact=${contact}&password=${password}")
        }
    }
}