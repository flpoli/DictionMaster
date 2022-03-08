package com.example.dictionmaster.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dictionmaster.data.remote.dto.WordDefinitionDto
import com.example.dictionmaster.presentation.search.SearchScreen
import com.example.dictionmaster.presentation.SplashScreen
import com.example.dictionmaster.presentation.purchase.PurchaseScreen
import com.example.dictionmaster.presentation.result.ResultScreen
import com.google.gson.Gson
import com.google.gson.GsonBuilder

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
            SearchScreen(navController = navController)
        }
        composable(
            route = Screen.ResultScreen.route + "/{lang}" + "/{word}",
            arguments = listOf(
                navArgument("lang"){type = NavType.StringType},
                navArgument("word"){type = NavType.StringType}
            )

        ){

            entry -> ResultScreen(
                navController = navController,
                lang = entry.arguments!!.getString("lang")!!,  // not the best way here
                word = entry.arguments!!.getString("word")!!,
                )
        }

        composable("purchase_screen"){
            PurchaseScreen(navController = navController)
        }
    }

}


