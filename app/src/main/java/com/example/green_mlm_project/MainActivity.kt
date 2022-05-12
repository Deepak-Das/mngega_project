package com.example.green_mlm_project

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.green_mlm_project.mngega_feature.presentaion.Registration.Register
import com.example.green_mlm_project.mngega_feature.presentaion.dashboard.Dashboard
import com.example.green_mlm_project.mngega_feature.presentaion.login.Login
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.Green_mlm_projectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Green_mlm_projectTheme {
                // A surface container using the 'background' color from the theme

                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            Login(navController = navController)
                        }
                        composable("register") {
                            Register(navController = navController)
                        }
                        composable("dashboard") {
                            Dashboard()
                        }
                    }
//                    Login()
//                    Register()
//                    Dashboard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello!!!!! $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Green_mlm_projectTheme {
        Greeting("Android")
    }
}