package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.primary_color))
        ) {
            Spacer(modifier = Modifier.padding(16.dp))
            Image(
                painter = painterResource(id = R.drawable.aman_bank_logo1),
                contentDescription = "Company Logo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(120.dp)
            )
            val pagerState = rememberPagerState(pageCount = { 2 })
            Box(modifier = Modifier.fillMaxWidth()) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Pagers(page = page)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row{
                    repeat(2) { page ->
                        CustomIndicators(selected = pagerState.currentPage == page)
                    }
                }
            }

        }
        Column(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Button(
                    onClick = { navController.navigate(Screens.Home.route) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.button_color)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Log In",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                Row {
                    HorizontalDivider(
                        thickness = 1.dp, modifier = Modifier
                            .weight(1f)
                            .padding(start = 4.dp, top = 12.dp),
                        color = colorResource(id = R.color.primary_color)
                    )
                    Text(
                        text = "Or",
                        fontFamily = FontFamily(Font(R.font.montserrat)),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                    HorizontalDivider(
                        thickness = 1.dp, modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp, top = 12.dp),
                        color = colorResource(id = R.color.primary_color)
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Text(
                text = "Go to Home Page",
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontSize = 17.sp,
                fontWeight = FontWeight.Black,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        navController.navigate(Screens.Home.route)
                    },
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

        }


    }

}

@Composable
fun CustomIndicators(
    selected: Boolean
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .background(
                color = if (selected) colorResource(id = R.color.slider_open_color) else colorResource(id = R.color.slider_close_color),
                shape = RoundedCornerShape(3.5.dp)
            )
            .size(width = 20.dp, height = 4.dp)
    )
}

@Composable
fun Pagers(page: Int){
    val titles = listOf("Welcome to Amanbanks", "Manage your Finance")
    val subtitles = listOf("Your best selection for financial transaction.", "Your finances at your fingertips.")
    val images = listOf(R.drawable.illustration_2,R.drawable.illustration_4)
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = "Company Logo",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(300.dp)
        )
        Text(
            text = titles[page],
            fontSize = 25.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = subtitles[page],
            fontSize = 15.sp,
            color = Color.White
        )
    }

}