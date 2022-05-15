package com.example.green_mlm_project.mngega_feature.presentaion.Registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.green_mlm_project.R
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.PrimaryColor
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.amzonblue
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.amzongreen


@Composable
fun Register(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()

) {

    var passwordVisible by remember { mutableStateOf(false) }

//    val focusRequester = FocusRequester()

    var (response, sponsorText, referal, spouse, firstName, lastName, contact, email, password, waring
    ) = viewModel.state.value

    if (response == null) {
        viewModel.setWaring(false)
    } else if (response.error_code == 22) {
        viewModel.setWaring(true)
    } else if (response.error_code == 11) {
        viewModel.setWaring(false)
    }

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
                    contentScale = ContentScale.FillBounds
                )

                Column(
                    Modifier
                        .fillMaxSize(1f)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    if (waring) {
                        Text(text = sponsorText, color = Color.Red);
                    }


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

                    Text(text = "Welcome to Green World", color = PrimaryColor)

                    OutlinedTextField(
                        value = referal,
                        label = { Text(text = "Enter Referral Id") },
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
                    OutlinedTextField(
                        value = spouse,
                        label = { Text(text = "Sponser Name") },
                        modifier = Modifier.padding(10.dp),
                        onValueChange = { value -> spouse = value },
                    )
                    OutlinedTextField(
                        value = firstName,
                        label = { Text(text = "Enter first Name") },
                        modifier = Modifier.padding(10.dp),
                        onValueChange = { value -> firstName = value },
                    )
                    OutlinedTextField(
                        value = lastName,
                        label = { Text(text = "Enter last Name") },
                        modifier = Modifier.padding(10.dp),
                        onValueChange = { value -> lastName = value },
                    )
                    OutlinedTextField(
                        value = contact,
                        label = { Text(text = "Enter contact NO.") },
                        modifier = Modifier.padding(10.dp),
                        onValueChange = { value -> contact = value },
                    )
                    OutlinedTextField(
                        value = email,
                        label = { Text(text = "Enter Email Address") },
                        modifier = Modifier.padding(10.dp),
                        onValueChange = { value -> email = value },
                    )
                    OutlinedTextField(
                        value = password,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        label = { Text(text = "Password") },
                        modifier = Modifier.padding(10.dp),
                        onValueChange = { value -> password = value },
                        trailingIcon = {
                            val image = if (passwordVisible)
                                Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff

                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = image, contentDescription = null)
                            }
                        }
                    )



                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Sign up")
                    }

//                    Box(modifier = Modifier.fillMaxWidth(1f).height(30.dp))
                }
            }
        },
    )

}