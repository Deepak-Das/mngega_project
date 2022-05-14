package com.example.green_mlm_project.mngega_feature.presentaion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.green_mlm_project.mngega_feature.presentaion.Registration.Register
import com.example.green_mlm_project.mngega_feature.presentaion.dashboard.Dashboard
import com.example.green_mlm_project.mngega_feature.presentaion.login.Login
import com.example.green_mlm_project.mngega_feature.presentaion.utli.Screen

@Composable
fun navigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route=Screen.Login.route) {
            Login(navController = navController)
        }
        composable(Screen.Register.route) {
            Register(navController = navController)
        }
        composable(Screen.Dashboard.route) {
            Dashboard()
        }
    }
}
