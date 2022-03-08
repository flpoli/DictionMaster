package com.example.dictionmaster.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dictionmaster.R
import kotlinx.coroutines.delay
import java.nio.file.WatchEvent


@Composable
fun SplashScreen(
    navController: NavHostController
) {


    LaunchedEffect(key1 = true) {
        delay(5000L)
        navController.navigate("search_screen")
    }



    AppLogoName()

        Text(
            modifier = Modifier

                .padding(bottom = 41.dp),
            text = stringResource(R.string.dev_name),
            style = MaterialTheme.typography.h3
        )
    }






@Composable
fun AppLogoName(){

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.padding(top = 60.dp),
                painter = painterResource(id = R.drawable.icon),
                contentDescription = stringResource(R.string.desc_logo_img)
            )
            Image(
                modifier = Modifier.padding(start = 22.dp, bottom = 200.dp),
                painter = painterResource(id = R.drawable.title),
                contentDescription = stringResource(R.string.desc_app_name_img)
            )
        }
    }

}