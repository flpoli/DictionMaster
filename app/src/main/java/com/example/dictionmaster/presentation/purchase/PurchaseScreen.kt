package com.example.dictionmaster.presentation.purchase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import com.example.dictionmaster.R
import java.nio.file.WatchEvent

@Composable
fun PurchaseScreen(){


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
                .padding(top = 80.dp),
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "user img on billing screen",
        )

        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 30.dp, top = 240.dp,),
            painter = painterResource(id = R.drawable.title),
            contentDescription = "user img on billing screen",
            )

        Column(
            modifier = Modifier.align(Alignment.BottomEnd),
            //verticalArrangement = Arrangement.Bottom,
            //horizontalAlignment = Alignment.End,
        ){
            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.subscribe_text)
            )
            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.offer_text)
            )
        }
    }




}















    }


        


    
