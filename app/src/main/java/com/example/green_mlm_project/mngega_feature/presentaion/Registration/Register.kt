package com.example.green_mlm_project.mngega_feature.presentaion.Registration

import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.green_mlm_project.R
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.PrimaryColor

@Composable
fun Register() {
    var referal by remember { mutableStateOf("") }
    var spouse by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var contect by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()



    Scaffold(

        content = {


            Column(
                Modifier
                    .fillMaxSize(1f)
                    .scrollable(state = scrollState,orientation = Orientation.Vertical,reverseDirection = true),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Card(
                    modifier = Modifier
                        .size(48.dp)
                        .testTag("circle"),
                    shape = CircleShape,
                    elevation = 2.dp
                ) {
                    Image(
                        painterResource(R.drawable.img),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(64.dp)
                    )
                }

                Text(text = "Welcome to Green World", color = PrimaryColor)

                OutlinedTextField(
                    value = referal,
                    label = { Text(text = "Enter Referral Id") },
                    modifier = Modifier.padding(10.dp),
                    onValueChange = { value -> referal = value },
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
                    value = contect,
                    label = { Text(text = "Enter contact NO.") },
                    modifier = Modifier.padding(10.dp),
                    onValueChange = { value -> contect = value },
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
            }
        },
    )

}