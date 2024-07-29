package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen( navController: NavController){
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(Screens.Onboarding.route){
            popUpTo(Screens.Splash.route) { inclusive = true }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
        .background(colorResource(id = R.color.primary_color))
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.aman_bank_logo1),
                contentDescription = "Splash Image",
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .weight(1f)
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Secured by AMAN BANK",
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 20.dp)
            )
        }
    }
}