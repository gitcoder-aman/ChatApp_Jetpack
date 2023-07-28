package com.tech.chatapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tech.chatapp.R
import com.tech.chatapp.components.ButtonComponent
import com.tech.chatapp.components.IconComponentImageVector
import com.tech.chatapp.components.SpacerHeight
import com.tech.chatapp.components.SpacerWidth
import com.tech.chatapp.navigation.Home
import com.tech.chatapp.ui.theme.AquaColor

@Composable
fun StartScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 220.dp)
                .background(Color.Black)
                .align(Alignment.Center)
        ) {

            Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 40.dp)) {
                Text(
                    text = stringResource(R.string.stay_connected_with_your_friend_and_family),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                SpacerHeight(20.dp)
                CustomCheckBox()
            }
        }
        ButtonComponent(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            navHostController.navigate(Home)
        }
    }
}

@Composable
fun CustomCheckBox() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp, topEnd = 10.dp, bottomEnd = 80.dp, bottomStart = 80.dp
                    )
                )
                .background(AquaColor)
                .size(24.dp), contentAlignment = Alignment.Center
        ) {
            IconComponentImageVector(icon = Icons.Default.Check, size = 15.dp, tint = Color.Black)
        }
        SpacerWidth()

        Text(text = "Secure, private messaging", style = TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ))
    }
}