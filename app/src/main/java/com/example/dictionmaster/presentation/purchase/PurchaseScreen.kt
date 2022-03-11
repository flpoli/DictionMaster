package com.example.dictionmaster.presentation.purchase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dictionmaster.R
import com.example.dictionmaster.navigation.Screen
import com.example.dictionmaster.presentation.components.ActionButton
import java.nio.file.WatchEvent

@Composable
fun PurchaseScreen(navController: NavHostController){


Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
){


    Box(
        modifier = Modifier.fillMaxSize(),
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart),

            painter = painterResource(id = R.drawable.billing_img),
            contentDescription = "user img on billing screen",
            contentScale = ContentScale.Crop,
        )

        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 50.dp),
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "user img on billing screen",
        )

        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 30.dp, top = 210.dp,),
            painter = painterResource(id = R.drawable.title),
            contentDescription = "user img on billing screen",
            )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 27.dp,bottom = 28.dp, end = 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
        ){

            Text(
                modifier = Modifier.padding(top = 60.dp),
                text = stringResource(id = R.string.subscribe_text),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier.padding(32.dp, 32.dp),
                text = stringResource(id = R.string.offer_text),
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,

                )

            ActionButton(
                text = stringResource(id = R.string.subscribe_btn),
                onBtnClick = {navController.navigate(Screen.SplashScreen.route)}
            )
        }
    }
}















    }


        


    
