package com.example.dictionmaster.presentation.result

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dictionmaster.R
import com.example.dictionmaster.navigation.Screen
import com.example.dictionmaster.presentation.components.ActionButton
import com.example.dictionmaster.util.playPronunciation

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
    val spellingIpa = w?.lexicalEntries?.get(0)?.entries?.get(0)?.pronunciations?.get(0)?.phoneticSpelling
    val definition = w?.lexicalEntries?.get(0)?.entries?.get(0)?.senses?.get(0)?.definitions
    val audioUrl = w?.lexicalEntries?.get(0)?.entries?.get(0)?.pronunciations?.get(0)?.audioFile

    Column(){
        if (w != null) {
            if (spellingIpa != null) {
                if (audioUrl != null) {
                    WordHeader(word = w.id, ipa = "/$spellingIpa/", audioFile = audioUrl )
                }
            }
        }



        if (definition != null) {
            DefSection(def = definition)
        }


        Divider(Modifier.fillMaxWidth())
        if (w != null) {
            WordFooter(word = w.id, navController = navController)
        }
    }



}

    @Composable
    fun WordHeader(
        word: String,
        audioFile: String,
        ipa: String
    ) {
        println(audioFile)
        Column() {

            Text(
                //modifier = Modifier.size(45.dp),
                text = word,
                style = MaterialTheme.typography.h2
            )

            Row() {

                Box() {
                    IconButton(
                        modifier = Modifier,
                        onClick = { playPronunciation(audioFile) }
                    ) {
                        Icon(imageVector = Icons.Filled.VolumeUp, contentDescription = "speaker button")

                    }





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

@Composable
fun DefSection(
    def: List<String>
){
    println(def)
    Text(text = def.toString(), style = MaterialTheme.typography.body1)
}