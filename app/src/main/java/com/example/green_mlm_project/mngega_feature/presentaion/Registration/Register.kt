package com.example.green_mlm_project.mngega_feature.presentaion.Registration

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.green_mlm_project.R
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.*
import com.example.green_mlm_project.mngega_feature.presentaion.utli.checkConnection
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@Composable
fun Register(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel(),
    context: Context=LocalContext.current

) {

    val scope= rememberCoroutineScope()
    var passwordVisible by remember { mutableStateOf(false) }
    var progress by remember { mutableStateOf(false) }


    var (
        sponsor_response,
        register_response,
        sponsorText, referal, spouse,
        firstName, lastName, contact,
        email, password, waring,
        registerStatus, registerText, connection
    ) = viewModel.state.value

    LaunchedEffect(sponsor_response){

        if (sponsor_response == null) {
            viewModel.setWaring(false)
        } else if (sponsor_response.error_code == 22) {
            viewModel.setWaring(true)

        } else if (sponsor_response.error_code == 11) {
            viewModel.setWaring(false)
        }
    }

//    LaunchedEffect(register_response){
//        progress=false
//    }
//    LaunchedEffect("fakeKey") {
//        scope.launch {
//            context.checkConnection().collect {
//                viewModel.setConnection(it);
//            }
//        }
//
//    }

    Scaffold(

        content = {

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
                    contentScale = ContentScale.Crop
                )
//                if(!connection){
//                    Box(
//                        Modifier
//                            .fillMaxWidth(1f)
//                            .heightIn(40.dp)
//                            .background(color = LightRed)
//                            .align(alignment = Alignment.TopCenter),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(text = "No Internet Connection",color = Color.White)
//
//
//                    }
//                }

                Card(
                    modifier = Modifier
                        .padding(15.dp),
                    elevation = 10.dp,shape = RoundedCornerShape(20.dp)

                ){


                    Column(
                        Modifier
                            .fillMaxSize(1f)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


//                    Card(
//                        modifier = Modifier
//                            .size(48.dp)
//                            .testTag("circle"),
//                        shape = CircleShape,
//                        elevation = 2.dp
//                    ) {
//                        Image(
//                            painterResource(R.drawable.img),
//                            contentDescription = "",
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier.size(64.dp)
//                        )
//                    }

                        Text(text = "Welcome to Green World", color = DarkGreen)


                        OutlinedTextField(
                            value = referal,
                            label = { Text(text = "SponsorId") },
                            isError = waring,
                            modifier = Modifier
                                .padding(10.dp)
                                .onFocusChanged {
                                    if (!it.isFocused) {
                                        viewModel.sponsorCheck()
                                    }
                                },
                            onValueChange = { value -> viewModel.setSponsorId(value) },
                        )
                        if (waring) {
                            Text(text = sponsorText, color = Color.Red);
                        }
                        OutlinedTextField(
                            value = spouse,
                            label = { Text(text = "Sponser Name") },
                            modifier = Modifier.padding(10.dp),
                            onValueChange = { value -> viewModel.setSpouse(value) },
                        )
                        OutlinedTextField(
                            value = firstName,
                            label = { Text(text = "Enter first Name") },
                            modifier = Modifier.padding(10.dp),
                            onValueChange = { value -> viewModel.setFirstName(value) },
                        )
                        OutlinedTextField(
                            value = lastName,
                            label = { Text(text = "Enter last Name") },
                            modifier = Modifier.padding(10.dp),
                            onValueChange = { value -> viewModel.setLastName(value) },
                        )
                        OutlinedTextField(
                            value = contact,
                            label = { Text(text = "Enter contact NO.") },
                            modifier = Modifier.padding(10.dp),
                            onValueChange = { value -> viewModel.setContact(value) },
                        )
                        OutlinedTextField(
                            value = email,
                            label = { Text(text = "Enter Email Address") },
                            modifier = Modifier.padding(10.dp),
                            onValueChange = { value -> viewModel.setEmail(value) },
                        )
                        OutlinedTextField(
                            value = password,
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            label = { Text(text = "Password") },
                            modifier = Modifier.padding(10.dp),
                            onValueChange = { value -> viewModel.setPassword(value) },
                            trailingIcon = {
                                val image = if (passwordVisible)
                                    Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff

                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(imageVector = image, contentDescription = null)
                                }
                            }
                        )


                        if (registerStatus)
                        {
                            Text(text = registerText, color = Color.Red)
                            Spacer(modifier = Modifier.height(15.dp))
                            progress=false
                        }

                        if(progress) {
                            Spacer(modifier = Modifier.height(10.dp))
                            CircularProgressIndicator()
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                        Button(onClick = {
                            progress=true
                            viewModel.registerAccount() }) {
                            Text(text = "Sign up")
                        }
                        
                        Spacer(modifier = Modifier.height(10.dp))




//                    Box(modifier = Modifier.fillMaxWidth(1f).height(30.dp))
                    }
                }

            }
        },
    )

}