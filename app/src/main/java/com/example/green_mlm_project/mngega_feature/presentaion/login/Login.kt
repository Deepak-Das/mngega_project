package com.example.green_mlm_project.mngega_feature.presentaion.login


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.green_mlm_project.R
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.Purple700
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.amzonblue
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.amzongreen
import com.example.green_mlm_project.mngega_feature.presentaion.utli.Screen
import kotlinx.coroutines.launch


fun toast(message: String, context: Context) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun Login(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()

) {

    val scope = rememberCoroutineScope()

    val state = viewModel.state.value


    var passwordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(false) }
    var passwordLabel by remember { mutableStateOf("Password") }

    var usernameLabel by remember { mutableStateOf("Username") }
    var errorText by remember { mutableStateOf("Please provide all data") }












    Scaffold(

        content = {


//            if (state.username.isEmpty()) {
//                viewModel.setWarning(false)
//                usernameLabel = "Username"
//            }
//            if (state.password.isEmpty()) {
//                viewModel.setWarning(false)
////        passwordHasError = false
//                passwordLabel = "Password"
//            }

            if (state.response?.error_code == 0) {
                navController.navigate(Screen.Dashboard.route){
                    popUpTo(Screen.Login.route) {
                        inclusive = true
                    }
                }
            }

            Box {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .drawWithCache {
                            val gradient = Brush.verticalGradient(
                                colors = listOf(amzonblue, amzongreen),
                                startY = size.height / 3,
                                endY = size.height
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient, blendMode = BlendMode.Multiply)
                            }
                        },
                    painter = painterResource(R.drawable.img2),
                    contentDescription = "background_image",
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    Modifier.fillMaxSize(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    if (state.warning) {
                        Text(text = state.errorText, color = Color.Red)
                    }


                    OutlinedTextField(
                        modifier = Modifier
                            .padding(10.dp)
//                            .onFocusChanged {
//                                if (it.isFocused){
//                                    viewModel.setWarning(false)
//                                }
//                            }
                        ,
                        value = state.username,
                        label = { Text(text = usernameLabel) },
                        onValueChange = { value -> scope.launch { viewModel.setUsername(value) } },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    )
                    OutlinedTextField(
                        value = state.password,
//                        isError = passwordHasError,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        label = { Text(text = passwordLabel) },
                        modifier = Modifier.padding(10.dp),
                        onValueChange = { value -> scope.launch { viewModel.setPassword(value) } },
                        trailingIcon = {
                            val image = if (passwordVisible)
                                Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff

                            // Please provide localized description for accessibility services
                            val description =
                                if (passwordVisible) "Hide password" else "Show password"

                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = image, description)
                            }
                        }
                    )
                    Row {
                        Button(onClick = {

                            viewModel.loginCall()
//                            navController.navigate(Screen.Dashboard.route)


                        }) {
                            Text("login")
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Button(onClick = { navController.navigate("register") }) {
                            Text(text = "Register")
                        }
                    }
                }
            }
        },
//        bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } }
    )


}

//fun Context.toast() {
//    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    Login()
}