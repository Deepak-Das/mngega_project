package com.example.green_mlm_project.mngega_feature.presentaion.login


import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.Purple700


fun toast(message: String, context: Context) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun Login(
    context: Context = LocalContext.current
) {

    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var passwordHasError by remember { mutableStateOf(false) }
    var passwordLabel by remember { mutableStateOf("Password") }

    var email by remember { mutableStateOf("") }
    var emailHasError by remember { mutableStateOf(false) }
    var emailLabel by remember { mutableStateOf("Username") }
    val materialBlue700 = Purple700

    if(email.isBlank()){
        emailHasError=false
        emailLabel="Username"
    }
    if(password.isNotBlank()){
        passwordHasError=false
        passwordLabel="Password"
    }
    Scaffold(
//        scaffoldState = scaffoldState,

        content = {

            Column(
                Modifier.fillMaxSize(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = email,
                    isError = emailHasError,
                    label = { Text(text = emailLabel) },
                    modifier = Modifier.padding(10.dp),
                    onValueChange = { value -> email = value },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                )
                OutlinedTextField(
                    value = password,
                    isError = passwordHasError,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    label = { Text(text = passwordLabel) },
                    modifier = Modifier.padding(10.dp),
                    onValueChange = { value -> password = value },
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Please provide localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, description)
                        }
                    }
                )
               Row {
                   Button(onClick = {
//                    when {
//                        password.isEmpty() -> {
//                            passwordHasError = true
//                            passwordLabel = "password can't be empty"
//                        }
//                        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
//                            emailHasError = true
//                            emailLabel = "Invalid email address"
//                        }
//                        else -> toast(message = "All fields are valid!", context)
//                    }
                   }) {
                       Text("login")
                   }
                   Spacer(modifier = Modifier.width(20.dp))
                   Button(onClick = { /*TODO*/ }) {
                       Text(text = "Register")
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
    Login()
}