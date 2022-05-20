package com.example.green_mlm_project.mngega_feature.presentaion.dashboard

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.BoxText
import com.example.green_mlm_project.mngega_feature.presentaion.ui.theme.PrimaryColor


@Composable
fun BoxButton(
    iconName: ImageVector = Icons.Default.Group,
    title: String = "Admin",
    subTitle: String = "My User(active)",
    boxColor: Color = PrimaryColor,
    iconBoxColor: Color = Color.Red,
) {
    val congfig= LocalConfiguration.current
    val height = 80.dp
    val screenWidth = congfig.screenWidthDp.dp - 100.dp
    Row(
        Modifier
            .width(screenWidth)
            .height(height), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .width(screenWidth - 100.dp)
                .fillMaxHeight(1f)
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
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxSize(1f), verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = title, color = BoxText, fontWeight = FontWeight.Bold)
                Text(text = subTitle, color = BoxText)
            }


        }
        Box(
            modifier = Modifier
                .fillMaxHeight(1f)
                .width(135.dp)
                .background(
                    shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp),
                    color = iconBoxColor
                ),
            Alignment.Center

        ) {

            Icon(
                imageVector = iconName, contentDescription = "", tint = BoxText, modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
            )
        }
    }
}