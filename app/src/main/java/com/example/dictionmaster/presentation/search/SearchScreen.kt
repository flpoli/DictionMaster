package com.example.dictionmaster.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dictionmaster.R
import com.example.dictionmaster.navigation.Screen
import com.example.dictionmaster.ui.theme.LightBlue

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavHostController

){


    SearchScreenContent(
        //viewState = {},
        onLanguageChange = viewModel::onLangSelected,
        onWordChange = viewModel::onWordEnter,
        viewModel = viewModel,
        navController = navController
    )


}

@Composable
fun SearchScreenContent(
    //viewState: SearchViewState,
    onLanguageChange: (String) ->  Unit,
    onWordChange: (String) -> Unit,
    viewModel: SearchViewModel,
    navController: NavController
){
    val word by viewModel.word
    Box(
        contentAlignment = Alignment.Center,
    ) {

        LangSelector(onLanguageChange = onLanguageChange,)

        Column(){
            SearchField(
                onTextChange = onWordChange,
                value = word,
            )

            SearchButton(
                onClick = {
                    val lang = "en-gb"
                    //viewModel.onSearchClicked("en-gb", word)

                    navController.navigate(Screen.ResultScreen.route + "/${lang}" +"/${word}")

                })
        }

    }




}

@Composable
fun LangSelector(
    modifier: Modifier = Modifier,
    onLanguageChange: (String) -> Unit
){


    var expanded by remember {mutableStateOf(false)}


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


@Composable
fun SearchField(
    onTextChange: (String) -> Unit,
    value: String
){

   TextField(
       value = value,
       onValueChange = onTextChange,
       placeholder = {Text(text = "Type a word...")},
       singleLine = true,

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
        Text(text = stringResource(id = R.string.search_btn))
    }
}