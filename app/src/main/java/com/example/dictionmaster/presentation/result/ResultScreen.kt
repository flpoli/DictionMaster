package com.example.dictionmaster.presentation.result

import android.text.TextUtils.indexOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.outlined.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dictionmaster.R
import com.example.dictionmaster.data.remote.dto.Sense
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

    // search for "grammaticalFeatures"

    val state = viewModel.searchState.value
    val w = viewModel.searchState.value.searchResult?.results?.get(0)?.lexicalEntries?.get(0)?.entries?.get(0)
    val spellingIpa = w?.pronunciations?.get(0)?.phoneticSpelling
    val definition = w?.senses
    val word = w?.senses?.get(0)?.domainClasses?.get(0)?.text

    val audioUrl = w?.pronunciations?.get(0)?.audioFile

    Column() {
        if (word != null) {
            if (spellingIpa != null) {
                if (audioUrl != null) {
                    WordHeader(word = word, ipa = "/$spellingIpa/", audioFile = audioUrl)
                }
            }
        }

        Spacer(modifier = Modifier.height(35.dp))

        if (definition != null) {
            DefinitionsSection(
                modifier = Modifier.padding(start = 30.dp, end = 53.dp),
                def = definition)
        }


        Divider(Modifier.fillMaxWidth())
        if (word != null) {
            WordFooter(word = word, navController = navController)
        }
    }


}

@Composable
fun WordHeader(
    word: String,
    audioFile: String,
    ipa: String
) {
    Column() {

        Text(
            modifier = Modifier.padding(top = 37.dp, start = 30.dp),
            text = word,
            style = MaterialTheme.typography.caption
        )

        Row(
            modifier = Modifier.padding(top = 13.dp, start = 30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.secondary,
                        shape = RoundedCornerShape(100.dp)
                    )
            ) {
                IconButton(
                    modifier = Modifier,
                    onClick = { playPronunciation(audioFile) }
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Filled.VolumeUp,
                        tint = Color.White,
                        contentDescription = "speaker button")
                }
            }
            Spacer(modifier = Modifier.width(11.dp))
            Text(
                text = ipa,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.primaryVariant

            )
        }

    }


}

@Composable
fun WordFooter(word: String, navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "That’s it for “$word”!",
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(R.string.new_search),
            style = MaterialTheme.typography.body2
        )

        Spacer(modifier = Modifier.height(15.dp))

        ActionButton(
            text = stringResource(R.string.new_search_btn),
            onBtnClick = { navController.navigate(Screen.SearchScreen.route) }
        )
    }

}

@Composable
fun DefinitionsSection(
    modifier: Modifier = Modifier,
    def: List<Sense>
) {

    println("DEFINITION SIZE: ${def.size}")

    def.size
    def.forEach { sense,  ->


            Definitions(
                //features = sense.grammaticalFeatures ,

                def = sense.definitions.toString(),
                shortDef = sense.shortDefinitions.toString().replace("[", "").replace("]", ""),
                examples = sense.examples.toString(), // it crashes depending of word. Null pointer

            )
        




    }
}

@Composable
fun Definitions(
    //features: String,
    def: String,
    shortDef: String,
    examples: String,
){

    Box(

    ){
        Column(
            modifier = Modifier.padding(start = 30.dp, end = 53.dp)
        ){
            Text(
                text = def,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = shortDef,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primary
            )
            Text(
                text = examples,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(15.dp))

        }

    }

}
