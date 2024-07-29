package com.example.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment.ui.theme.AssignmentTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    navigation()
                }
            }
        }
    }
}

@Composable
fun navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Splash.route ){
        composable(Screens.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(Screens.Onboarding.route){
            OnboardingScreen(navController = navController)
        }
        composable(Screens.Home.route){
            HomeScreen(navController = navController)
        }
    }
}
