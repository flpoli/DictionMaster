package com.example.dictionmaster.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dictionmaster.R
import com.example.dictionmaster.navigation.Screen
import com.example.dictionmaster.presentation.components.ActionButton
import com.example.dictionmaster.presentation.components.LangSelector

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavHostController

){
    SearchScreenContent(
        onLanguageChange = viewModel::onLangSelected,
        onWordChange = viewModel::onWordEnter,
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
fun SearchScreenContent(
    onLanguageChange: (String) ->  Unit,
    onWordChange: (String) -> Unit,
    viewModel: SearchViewModel,
    navController: NavController
){
    val word by viewModel.word
    val langCode by viewModel.langCode
    var countLimit by remember { viewModel.countLimit }

    val langs = listOf("ENGLISH", "SPANISH", "FRENCH")


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 38.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LangSelector(
                languages = langs,
                )

        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){

            SearchField(
                onTextChange = onWordChange,
                value = word,
            )

            Spacer(modifier = Modifier.height(30.dp))

            SearchButton(
                onClick = {

                    if(viewModel.onSearchLimitReached(countLimit)){
                        navController.navigate(Screen.PurchaseScreen.route)
                    } else {
                        navController.navigate(Screen.ResultScreen.route + "/${langCode}" +"/${word}")
                        countLimit++
                    }

                }
            )
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

       textStyle = MaterialTheme.typography.h1,

       placeholder = {
           Text(
               text = stringResource(id = R.string.input_placeholder),
               style = MaterialTheme.typography.h1,
               textAlign = TextAlign.Center


           )},
       singleLine = true,
       colors = TextFieldDefaults.textFieldColors(
           textColor = MaterialTheme.colors.primary,
           disabledTextColor = Color.Transparent,
           backgroundColor = Color.Transparent,
           focusedIndicatorColor = Color.Transparent,
           unfocusedIndicatorColor = Color.Transparent,
           disabledIndicatorColor = Color.Transparent
       )

   )

}

@Composable
fun SearchButton(
    onClick: () -> Unit){

   ActionButton(
       text = stringResource(id = R.string.search_btn),
       onBtnClick = onClick,
   )
}