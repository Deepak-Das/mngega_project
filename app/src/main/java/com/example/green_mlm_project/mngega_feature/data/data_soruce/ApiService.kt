package com.example.green_mlm_project.mngega_feature.data.data_soruce

import com.example.green_mlm_project.mngega_feature.Domain.model.LoginResponse
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

    suspend fun login(username:String="GW77088",password:String="aaazzz"):LoginResponse{
        return client.get {
            url("https://api.greenworld.in.net/login.php?usersid=${username}&password=${password}")
        }
    }
}