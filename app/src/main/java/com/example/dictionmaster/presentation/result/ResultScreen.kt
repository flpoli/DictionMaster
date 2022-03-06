package com.example.dictionmaster.presentation.result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.example.dictionmaster.data.remote.dto.WordDefinitionDto
import com.example.dictionmaster.presentation.search.SearchViewModel

@Composable
fun ResultScreen(
    viewModel: ResultScreenViewModel = hiltViewModel(),
    navController: NavHostController,
    lang: String,
    word: String
){
    viewModel.onSearchClicked(lang, word)

    val w = viewModel.searchState.data


    WordHeader(word = w.id , ipa = )


}

@Composable
fun WordHeader(
    word: String,
    audio: String? = null, // por enquanto
    ipa: String
){

    Column(){

        Text(text = word)

        Row(){

            Box(){
                Icon(imageVector = Icons.Filled.VolumeUp, contentDescription = "speaker button")
            }
            Text(text = ipa)
        }

    }



}