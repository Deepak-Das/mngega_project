package com.example.green_mlm_project.mngega_feature.presentaion.dashboard

import android.content.Context
import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.green_mlm_project.Greeting
import com.example.green_mlm_project.R
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.*
import kotlinx.coroutines.launch



@Composable
fun Dashboard() {
    val materialBlue700 = Color(0xFF1976D2)
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    Scaffold(
        scaffoldState = scaffoldState,

        topBar = {
            TopAppBar(
                title = { Text("Green World") },
                backgroundColor = PrimaryColor,
                navigationIcon = {
                    IconButton(onClick = {
//                        scope.launch {
//                            scaffoldState.drawerState.open()
//                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        },

//        drawerContent = {
//            DrawerContent()
//        },
        content = {
            Box {
                Image(
                    modifier = Modifier.fillMaxSize().drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(amzonblue, amzongreen),
                            startY = size.height/3,
                            endY = size.height
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient,blendMode = BlendMode.Multiply)
                        }
                    },
                    painter = painterResource(R.drawable.img2),
                    contentDescription = "background_image",
                    contentScale = ContentScale.FillBounds
                )
                Column(modifier = Modifier
                    .padding(PaddingValues(top = 10.dp))
                    .fillMaxSize(1f),horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(Modifier.fillMaxWidth(1f),horizontalArrangement = Arrangement.SpaceAround) {

                        BoxButton(iconName = Icons.Default.Person)
                        BoxButton(iconName = Icons.Default.Groups,title="0",subTitle = "DIRECT REFERAL",boxColor = SkyBlue)
                    }

                    Spacer(Modifier.height(10.dp))


                    Row(Modifier.fillMaxWidth(1f),horizontalArrangement = Arrangement.SpaceAround) {

                        BoxButton(iconName = Icons.Default.Groups,title="3",subTitle = "AUTO UPGRADE",boxColor = DarkYellow)
                        BoxButton(iconName = Icons.Default.Groups,title="3",subTitle = "MY TEAM",iconBoxColor = DarkGreen)
                    }

                    Spacer(Modifier.height(10.dp))
                    Row(Modifier.fillMaxWidth(1f),horizontalArrangement = Arrangement.SpaceAround) {

                        BoxButton(iconName = Icons.Default.Groups,title="0",subTitle = "INACTIVE",boxColor = LightRed,iconBoxColor = DarkGreen)
                        BoxButton(iconName = Icons.Default.Money,title="46535/-",subTitle = "E-WALLET",iconBoxColor = NaviBlue)
                    }

                    Spacer(Modifier.height(10.dp))

                    Row(Modifier.fillMaxWidth(1f),horizontalArrangement = Arrangement.SpaceAround) {
                        BoxButton(iconName = Icons.Default.PushPin,title="79",subTitle = "AVAILABLE e-PIN",boxColor = DarkYellow,iconBoxColor = NaviBlue)
                        BoxButton(iconName = Icons.Default.PushPin,title="9",subTitle = "EXPIRED e-PIN",boxColor = LightRed,iconBoxColor = DarkGreen)
                    }
                    Spacer(Modifier.height(10.dp))

                    Row(Modifier.fillMaxWidth(1f),horizontalArrangement = Arrangement.Center) {
                        BoxButton(iconName = Icons.Default.Money,title="100",subTitle = "TOTAL INCOME",boxColor = DarkYellow,iconBoxColor = LightRed)
                    }




                }
            }
                  },
    )
}

@Composable
fun DrawerContent(
) {
    Column (
        Modifier
            .background(color = GrayDark)
            .fillMaxSize(1f)){
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
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Green_mlm_projectTheme {
        BoxButton()
    }
}
@Composable
fun BoxButton(
    iconName:ImageVector=Icons.Default.Group,
    title:String="Admin",
    subTitle:String="My User(active)",
    boxColor:Color= PrimaryColor,
    iconBoxColor:Color= Color.Red,
) {
   Row(
       Modifier
           .width(180.dp)
           .height(50.dp),horizontalArrangement = Arrangement.SpaceBetween) {
       Box(
           modifier = Modifier
               .width(135.dp)
               .height(50.dp)
               .background(
                   shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp),
                   color = boxColor
               )
               .clickable {
                   Log.i(
                       "TAG",
                       "BoxButton: click"
                   )
               },

       ) {
           Row() {
               Column(Modifier.padding(4.dp)) {
                   Text(text = title,color = BoxText,fontWeight = FontWeight.Bold)
                   Text(text = subTitle,color= BoxText)
               }

           }
       }
       Box(
           modifier = Modifier
               .fillMaxHeight(1f)
               .width(45.dp)
               .background(
                   shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp),
                   color = iconBoxColor
               ),
           Alignment.Center

       ) {

           Icon(imageVector = iconName, contentDescription = "",tint = BoxText,modifier = Modifier
               .size(40.dp)
               .padding(8.dp) )
       }
   }
}