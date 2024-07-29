package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }

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
            Image(
                painter = painterResource(id = R.drawable.illustration_2),
                contentDescription = "Company Logo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp)
            )
            Text(
                text = "Welcome to Amanbanks",
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Your best selection for finanicial transaction.",
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.padding(horizontal = 150.dp)
            ) {
                HorizontalDivider(
                    thickness = 2.dp, modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp, top = 12.dp),
                    color = colorResource(id = R.color.slider_close_color)
                )
                Spacer(modifier = Modifier.width(4.dp))
                HorizontalDivider(
                        thickness = 2.dp, modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp, top = 12.dp),
                    color = colorResource(id = R.color.slider_open_color)
                )
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