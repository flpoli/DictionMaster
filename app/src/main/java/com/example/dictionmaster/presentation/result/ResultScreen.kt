package com.example.dictionmaster.presentation.result

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.example.dictionmaster.R
import com.example.dictionmaster.data.remote.dto.WordDefinitionDto
import com.example.dictionmaster.navigation.Screen
import com.example.dictionmaster.presentation.components.ActionButton
import com.example.dictionmaster.presentation.search.SearchViewModel

@Composable
fun ResultScreen(
    viewModel: ResultScreenViewModel = hiltViewModel(),
    navController: NavHostController,
    lang: String,
    word: String
) {
    viewModel.onSearchClicked(lang, word)

    val state = viewModel.searchState.value
    val w = viewModel.searchState.value.searchResult?.results?.get(0)
    val spellingIpa =
        w?.lexicalEntries?.get(0)?.entries?.get(0)?.pronunciations?.get(0)?.phoneticSpelling


    if (w != null) {
        if (spellingIpa != null) {
            WordHeader(word = w.id, ipa = "/$spellingIpa/" )
        }
    }

    if (w != null) {
        WordFooter(word = w.id, navController = navController)
    }


}

    @Composable
    fun WordHeader(
        word: String,
        audio: String? = null, // por enquanto
        ipa: String
    ) {

        Column() {

            Text(
                //modifier = Modifier.size(45.dp),
                text = word,
                style = MaterialTheme.typography.h2
            )

            Row() {

                Box() {
                    Icon(imageVector = Icons.Filled.VolumeUp, contentDescription = "speaker button")
                }
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = ipa,
                    style = MaterialTheme.typography.subtitle1

                )
            }

        }


    }

    @Composable
    fun WordFooter(word: String, navController: NavHostController){

        Column() {

            Text(
                text = "That’s it for “$word”!",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = stringResource(R.string.new_search),
                style = MaterialTheme.typography.body2
            )

            ActionButton(
                text = stringResource(R.string.new_search_btn),
                onBtnClick = {navController.navigate(Screen.SearchScreen.route)}
            )
        }

    }