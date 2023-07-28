package com.tech.chatapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tech.chatapp.R
import com.tech.chatapp.components.IconComponentDrawable
import com.tech.chatapp.components.IconComponentImageVector
import com.tech.chatapp.components.SpacerHeight
import com.tech.chatapp.components.SpacerWidth
import com.tech.chatapp.data.Person
import com.tech.chatapp.data.personList
import com.tech.chatapp.navigation.Chat
import com.tech.chatapp.ui.theme.DarkGrayColor
import com.tech.chatapp.ui.theme.Gray400Color
import com.tech.chatapp.ui.theme.GrayColor
import com.tech.chatapp.ui.theme.LineColor
import com.tech.chatapp.ui.theme.YellowColor

@Composable
fun HomeScreen(navHostController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            HeaderAndStory()

            //Bottom Sheet
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)
            ) {

                BottomSheetSwipe(
                    modifier = Modifier
                        .align(TopCenter)
                        .padding(top = 15.dp)
                )
                LazyColumn(modifier = Modifier.padding(top = 30.dp, bottom = 15.dp)) {
                    items(personList, key = { it.id }) {
                        UserEachRow(person = it) {
//                            Navigate another activity with data
                            navHostController.currentBackStackEntry?.savedStateHandle?.set("data",it)
                            navHostController.navigate(Chat)

                        }
                    }
                }

            }

        }
    }
}

@Composable
fun UserEachRow(
    modifier: Modifier = Modifier,
    person: Person,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable {
                onClick()
            }
            .padding(horizontal = 20.dp, vertical = 5.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconComponentDrawable(icon = person.icon, size = 60.dp)
                    SpacerWidth()

                    Column {
                        Text(
                            text = person.name, style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        SpacerHeight(5.dp)
                        Text(
                            text = "Okay", style = TextStyle(
                                color = GrayColor,
                                fontSize = 14.sp
                            )
                        )
                    }
                }
                Text(
                    text = "12:00 PM", style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp,
                    )
                )
            }
            SpacerHeight(15.dp)

            Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = LineColor)
        }
    }
}

@Composable
fun BottomSheetSwipe(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(90.dp))
            .width(90.dp)
            .height(5.dp)
            .background(
                Gray400Color
            )
    )
}

@Composable
fun Header() {
    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300,
            )
        ) {
            append(stringResource(R.string.welcome_back))
        }
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        ) {
            append(stringResource(R.string.aman))
        }
    }
    Text(text = text)
}

@Composable
fun AddStoryLayout() {

    Column {

        Box(
            modifier = Modifier
                .border(2.dp, DarkGrayColor, shape = CircleShape)
                .background(YellowColor, shape = CircleShape)
                .size(70.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .size(20.dp),
                contentAlignment = Alignment.Center
            ) {
                IconComponentImageVector(
                    icon = Icons.Default.Add,
                    size = 12.dp,
                    tint = YellowColor
                )
            }
        }
        SpacerHeight(8.dp)
        Text(
            text = stringResource(R.string.add_story), style = TextStyle(
                fontSize = 13.sp,
                color = Color.White
            ), modifier = Modifier.align(CenterHorizontally)
        )
    }
}

@Composable
fun UserStoryLayout(modifier: Modifier = Modifier, person: Person) {

    Column(modifier = modifier.padding(end = 10.dp)) {
        Box(
            modifier = Modifier
                .background(YellowColor, CircleShape)
                .clip(CircleShape)
                .size(70.dp), contentAlignment = Alignment.Center
        ) {
            IconComponentDrawable(icon = person.icon, size = 65.dp, tint = Color.Unspecified)
        }
        SpacerHeight(8.dp)

        Text(
            text = person.name, style = TextStyle(
                fontSize = 13.sp,
                color = Color.White
            ), modifier = Modifier.align(CenterHorizontally)
        )
    }
}

@Composable
fun ViewStoryLayout() {

    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
        item {
            AddStoryLayout()
            SpacerWidth()
        }
        items(personList, key = { it.id }) {
            UserStoryLayout(person = it)
        }
    }

}

@Composable
fun HeaderAndStory() {
    Column(modifier = Modifier.padding(start = 15.dp, top = 20.dp, end = 10.dp)) {
        Header()
        ViewStoryLayout()
    }
}