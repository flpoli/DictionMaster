package com.example.dictionmaster.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.dictionmaster.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavHostController
) {


    LaunchedEffect(key1 = true) {
        delay(4500L)
        navController.navigate("search_screen")
    }



    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {

        Column {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = stringResource(R.string.desc_logo_img)
            )
            Image(
                painter = painterResource(id = R.drawable.title),
                contentDescription = stringResource(R.string.desc_app_name_img)
            )
        }

        Text(
            text = stringResource(R.string.dev_name)
        )
    }
}
