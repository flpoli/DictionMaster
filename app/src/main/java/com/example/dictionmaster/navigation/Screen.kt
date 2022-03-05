package com.example.dictionmaster.navigation

sealed class Screen(val route: String){

    object SplashScreen: Screen("splash_screen")
    object SearchScreen: Screen("search_screen")

}
