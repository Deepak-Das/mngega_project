package com.example.green_mlm_project.mngega_feature.presentaion.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.PrimaryColor

@Composable
fun Dash(navController: NavController){
   Scaffold(Modifier.fillMaxSize(1f),
       topBar = {
           TopAppBar(
               title = { Text("Green World") },
               backgroundColor = PrimaryColor,
               navigationIcon = {
                   IconButton(onClick = {

                   }) {
                       Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                   }
               }
           )
       }
       ) {
       LazyColumn(
           Modifier.fillMaxSize(1f).padding(vertical = 10.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           items(messages) { message ->
               BoxButton(title = message.title,subTitle = message.subTitle,iconName = message.iconName,boxColor = message.boxColor,iconBoxColor = message.iconBoxColor)
               Spacer(modifier = Modifier.height(20.dp))

           }
       }
   }
}