package com.example.assignment

sealed class Screens( val route : String) {

    object Splash : Screens("splash_screen")
    object Onboarding : Screens("onboarding_screen")
    object Home : Screens("home_screen")

}