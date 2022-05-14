package com.example.green_mlm_project.mngega_feature.presentaion.utli

sealed class Screen(val route:String){
    object Login:Screen("Login")
    object Register:Screen("Register")
    object Dashboard:Screen("Dashboard")

}
