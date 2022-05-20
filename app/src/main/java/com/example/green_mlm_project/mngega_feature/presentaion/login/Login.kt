package com.example.green_mlm_project.mngega_feature.presentaion.login


import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.green_mlm_project.R
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.LightRed
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.PrimaryColor
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.amzonblue
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.amzongreen
import com.example.green_mlm_project.mngega_feature.presentaion.utli.Screen
import com.example.green_mlm_project.mngega_feature.presentaion.utli.checkConnection
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


fun toast(message: String, context: Context) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun Login(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
    context:Context= LocalContext.current,

) {

    val scope= rememberCoroutineScope()
    var startProgressBar by remember{ mutableStateOf(false) }
    var count by remember{ mutableStateOf(1) }


    val state = viewModel.state.value



    LaunchedEffect(state.response?.error_code) {
        startProgressBar=false
        if (state.response?.error_code == 0) {
            navController.navigate(Screen.Dashboard.route){
                popUpTo(Screen.Dashboard.route)
            }

        }
    }

    LaunchedEffect("fakeKey") {
        scope.launch {
            context.checkConnection().collect {
                viewModel.setConnection(it);

            }

        }

    }



    DisposableEffect(key1 = state.response?.error_code==0) {
        onDispose {
            viewModel.setState()
        }
    }

    var passwordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(false) }

    Log.i("TAG", "Login: ${state.response}")






    Scaffold(

        content = {

            Box(contentAlignment = Alignment.Center) {


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
                    contentScale = ContentScale.Crop
                )
                if(!state.contection){
                    Box(
                        Modifier
                            .fillMaxWidth(1f)
                            .heightIn(40.dp)
                            .background(color = LightRed)
                            .align(alignment = Alignment.TopCenter),
                    contentAlignment = Alignment.Center
                        ) {
                            Text(text = "No Internet Connection",color = Color.White)


                    }
                }
                Card(
                    modifier = Modifier
                        .padding(15.dp),
                    elevation = 10.dp,shape = RoundedCornerShape(20.dp)

                    ) {
                    Column(
                        Modifier
                            .fillMaxWidth(1f)
                            .height(LocalConfiguration.current.screenHeightDp.dp / 2),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(text = "Login",color = PrimaryColor)
                        if (state.warning) {
                            Text(text = state.errorText, color = Color.Red)
                        }


                        if(startProgressBar&&state.response==null) {
                            Spacer(modifier = Modifier.height(10.dp))
                            CircularProgressIndicator()
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                        OutlinedTextField(
                            modifier = Modifier
                                .padding(10.dp),

                            value = state.username,
                            label = { Text(text = "Username") },
                            onValueChange = { value -> viewModel.setUsername(value) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        )
                        OutlinedTextField(
                            value = state.password,
//                        isError = passwordHasError,
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            label = { Text(text = "Password") },
                            modifier = Modifier.padding(10.dp),
                            onValueChange = { value -> viewModel.setPassword(value) },
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
                                startProgressBar=true
                                if(state.contection)
                                    viewModel.loginCall()
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

            }
        },
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
//
//fun Context.isConnected():Boolean {
//    var connected = false;
//    val connectivityManager =
//        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;
//
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//        val nw = connectivityManager.activeNetwork ?: return false
//        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
//        connected = when {
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//            //for other device how are able to connect with Ethernet
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//            //for check internet over Bluetooth
//            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
//            else -> false
//        }
//    } else {
//        val nwInfo = connectivityManager.activeNetworkInfo ?: return false
//        connected = nwInfo.isConnected
//    }
//
//
//    return connected;
//}



