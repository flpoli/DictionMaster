package com.example.dictionmaster.presentation.search

import android.graphics.Paint
import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictionmaster.R
import com.example.dictionmaster.ui.theme.LightBlue
import java.nio.file.WatchEvent

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
){

    Box(
        contentAlignment = Alignment.Center,

        ) {



        LangSelector()
        Column(){
            SearchField()

            SearchButton(
                onClick = {viewModel.onSearchClicked("en-gb", "education")})
        }


    }


}

@Preview
@Composable
fun LangSelector(
    modifier: Modifier = Modifier
){


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Green,

                ),
        contentAlignment = Alignment.Center,


        ){


        Box(
            //contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .align(Alignment.TopCenter)
                .padding(20.dp)
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(100.dp)
                )
                .clickable {
                    //onClick()
                },

            ){

            Row() {
                Image(
                    painter = painterResource(id = R.drawable.english_icon),
                    contentDescription = "language selection icon"
                )
                Text("ENGLISH")
            }

        }
    }

}

@Preview
@Composable
fun SearchField(){

    val textState = remember {mutableStateOf("")}

   TextField(
       value = textState.value,
       onValueChange = { textState.value = it },
       placeholder = {Text(text = "Type a word...")}
   )

}

@Composable
fun SearchButton(onClick: () -> Unit){

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(
                color = LightBlue,
                shape = RoundedCornerShape(30.dp),
            )
            .clickable {
                onClick()
            }
    ){
        Text(text = "SEARCH")
    }
}