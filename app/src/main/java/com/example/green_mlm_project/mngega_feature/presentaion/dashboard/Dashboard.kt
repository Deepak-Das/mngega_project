package com.example.green_mlm_project.mngega_feature.presentaion.dashboard

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.green_mlm_project.R
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.*

import androidx.hilt.navigation.compose.hiltViewModel

//val messages = listOf(
//    Item(
//        title = "Admin",
//        subTitle = "MyUser(active)",
//        iconName = Icons.Default.Person,
//        boxColor = PrimaryColor,
//        iconBoxColor = Color.Red
//    ),
//    Item(
//        title = "0",
//        subTitle = "DIRECT REFERAL",
//        iconName = Icons.Default.Group,
//        boxColor = SkyBlue,
//        iconBoxColor = Color.Red
//    ),
//    Item(
//        title = "3",
//        subTitle = "AUTO UPGRADE",
//        iconName = Icons.Default.Group,
//        boxColor = DarkYellow,
//        iconBoxColor = Color.Red
//    ),
//    Item(
//        iconName = Icons.Default.Groups,
//        title = "3",
//        subTitle = "MY TEAM",
//        iconBoxColor = DarkGreen
//    ),
//
//    Item(
//        iconName = Icons.Default.Groups,
//        title = "0",
//        subTitle = "INACTIVE",
//        boxColor = LightRed,
//        iconBoxColor = DarkGreen
//    ),
//    Item(
//        iconName = Icons.Default.Money,
//        title = "46535/-",
//        subTitle = "E-WALLET",
//        iconBoxColor = NaviBlue
//    ),
//    Item(
//        iconName = Icons.Default.PushPin,
//        title = "79",
//        subTitle = "AVAILABLE e-PIN",
//        boxColor = DarkYellow,
//        iconBoxColor = NaviBlue
//    ),
//    Item(
//        iconName = Icons.Default.PushPin,
//        title = "9",
//        subTitle = "EXPIRED e-PIN",
//        boxColor = LightRed,
//        iconBoxColor = DarkGreen
//    ),
//    Item(
//        iconName = Icons.Default.Money,
//        title = "100",
//        subTitle = "TOTAL INCOME",
//        boxColor = DarkYellow,
//        iconBoxColor = LightRed
//    ),
//)

//
//Id HOLDER NAME
//MY STATUS
//DIRECT REFERRAL
//MY TEAM
//INACTIVE TEAM
//SELF INCOME
//LEVEL WALLET
//MEN WALLET
//AVAILABLE E PIN
//EXPIRE EPIN
//TOTAL INCOME
//REFERRAL LINK
//TOP 20 LEADERS


@Composable
fun Dashboard(
    navController: NavController,
    viewModel: DashbordViewModel= hiltViewModel(),
    primaryKey: String?

    ) {
//    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
//    Log.d("TAG", "primarykey: ${primaryKey}")
    val state=viewModel.state.value
    var dashList by remember {
        mutableStateOf(emptyList<Item>())
    }


    LaunchedEffect(key1 = state.response){
//        viewModel.setreponse(primaryKey)
        dashList = listOf(
            Item(
                title = state.response.HOLDER_NAME,
                subTitle = "MyUser(${state.response.STATUS})",
                iconName = Icons.Default.Person,
                boxColor = PrimaryColor,
                iconBoxColor = Color.Red
            ),
            Item(
                title = state.response.DIRECT_REFERRAL,
                subTitle = "DIRECT REFEERAL",
                iconName = Icons.Default.Group,
                boxColor = SkyBlue,
                iconBoxColor = Color.Red
            ),
//            Item(
//                title = "3",
//                subTitle = "AUTO UPGRADE",
//                iconName = Icons.Default.Group,
//                boxColor = DarkYellow,
//                iconBoxColor = Color.Red
//            ),
            Item(
                iconName = Icons.Default.Groups,
                title = state.response.MY_TEAM,
                subTitle = "MY TEAM",
                iconBoxColor = DarkGreen
            ),

            Item(
                iconName = Icons.Default.Groups,
                title = state.response.INACTIVE_TEAM,
                subTitle = "INACTIVE",
                boxColor = LightRed,
                iconBoxColor = DarkGreen
            ),
//            Item(
//                iconName = Icons.Default.Money,
//                title = "46535/-",
//                subTitle = "E-WALLET",
//                iconBoxColor = NaviBlue
//            ),
//            Item(
//                iconName = Icons.Default.PushPin,
//                title = "79",
//                subTitle = "AVAILABLE e-PIN",
//                boxColor = DarkYellow,
//                iconBoxColor = NaviBlue
//            ),
//            Item(
//                iconName = Icons.Default.PushPin,
//                title = "9",
//                subTitle = "EXPIRED e-PIN",
//                boxColor = LightRed,
//                iconBoxColor = DarkGreen
//            ),
            Item(
                iconName = Icons.Default.Money,
                title = "100",
                subTitle = "TOTAL INCOME",
                boxColor = DarkYellow,
                iconBoxColor = LightRed
            ),
        )
    }

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
            Content(dashList = dashList)
//                  content2()
        },
    )
}



@Composable
fun DrawerContent(
) {
    Column(
        Modifier
            .background(color = GrayDark)
            .fillMaxSize(1f)
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
    }
}

@Composable
fun Content( dashList: List<Item>) {
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



        LazyColumn(
            Modifier
                .fillMaxSize(1f)
                .padding(vertical = 10.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(dashList) { message ->
                BoxButton(
                    title = message.title,
                    subTitle = message.subTitle,
                    iconName = message.iconName,
                    boxColor = message.boxColor,
                    iconBoxColor = message.iconBoxColor)
                Spacer(modifier = Modifier.height(20.dp))

            }
        }
        
    }
}
data class Item(
    val title: String,
    val subTitle: String,
    val iconName: ImageVector = Icons.Default.Group,
    val boxColor: Color = PrimaryColor,
    val iconBoxColor: Color = Color.Red
)




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Green_mlm_projectTheme {
        BoxButton()
    }
}

