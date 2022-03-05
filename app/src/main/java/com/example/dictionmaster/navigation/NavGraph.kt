package com.example.dictionmaster.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dictionmaster.presentation.search.SearchScreen
import com.example.dictionmaster.presentation.SplashScreen
import com.example.dictionmaster.presentation.purchase.PurchaseScreen

@Composable
fun SetupNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination =  Screen.SplashScreen.route
    ){
        
        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        composable("search_screen"){
            SearchScreen()
        }

        composable("purchase_screen"){
            PurchaseScreen()
        }
    }

}


