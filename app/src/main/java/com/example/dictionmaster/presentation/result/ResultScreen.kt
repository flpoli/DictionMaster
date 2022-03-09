package com.example.dictionmaster.presentation.result

import android.text.TextUtils.indexOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dictionmaster.R
import com.example.dictionmaster.data.remote.dto.Example
import com.example.dictionmaster.data.remote.dto.Sense
import com.example.dictionmaster.data.remote.dto.Subsense
import com.example.dictionmaster.navigation.Screen
import com.example.dictionmaster.presentation.components.ActionButton
import com.example.dictionmaster.util.playPronunciation
import java.nio.file.WatchEvent


fun parseResponse(res: List<String>): String {

    return res.toString().replace("[", "").replace("]", "")
}

@Composable
fun ResultScreen(
    viewModel: ResultScreenViewModel = hiltViewModel(),
    navController: NavHostController,
    lang: String,
    word: String
) {
    viewModel.onSearchClicked(lang, word)
    val word = viewModel.searchState.value.searchResult
    val result = viewModel.searchState.value.searchResult?.results
    val w =
        viewModel.searchState.value.searchResult?.results?.get(0)?.lexicalEntries?.get(0)?.entries?.get(
            0
        )
    val spelling = w?.pronunciations?.get(0)?.phoneticSpelling
    val audioUrl = w?.pronunciations?.get(0)?.audioFile
    val senses = w?.senses

    LazyColumn() {

        item {
            if (word != null && spelling != null && audioUrl != null) {
                WordHeader(
                    word = word.id,
                    audioFile = audioUrl,
                    ipa = spelling
                )
            }
        }
        item {
            result?.forEach { _ ->

                DefinitionsSection(
                    def = senses
                )
            }

        }


        item {
            if (word != null) {
                WordFooter(word = word.id, navController)
            }
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
                            contentDescription = "speaker button"
                        )
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

        Divider()

        Column(modifier = Modifier.padding(start = 30.dp, top = 20.dp)) {
            Text(
                text = "That’s it for “$word”!",
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Left
            )
            Text(
                text = stringResource(R.string.new_search),
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Left
            )
        }



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {



            Spacer(modifier = Modifier.height(10.dp))

            ActionButton(
                text = stringResource(R.string.new_search_btn),
                onBtnClick = { navController.navigate(Screen.SearchScreen.route) }
            )
        }

    }

    @Composable
    fun DefinitionsSection(
        modifier: Modifier = Modifier,
        def: List<Sense>?
    ) {
        def?.forEachIndexed { index, sense ->
            Definitions(
                index = index,
                def = parseResponse(sense.definitions),//sense.definitions,
                shortDef = parseResponse(sense.shortDefinitions),
                examples = sense.examples,
                subsenses = sense.subsenses
            )
        }
    }

    @Composable
    fun Definitions(
        index: Int,
        def: String,
        shortDef: String,
        examples: List<Example>?,
        subsenses: List<Subsense>?,
    ) {

        Box(
            modifier = Modifier.padding(start = 30.dp, end = 53.dp, top = 20.dp)
        ) {

            Column(){

                Text(
                    text = "${index + 1}) $def",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = " SHORT $shortDef ",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.height(10.dp))

                examples?.forEach { it ->
                    Text(
                        text = "EXAMPLE ${it.text}",
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.primary
                    )

                subsenses?.forEach {
                    Text(
                        text = " SUB DEF ${it.definitions}",
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.primary
                    )
                    Text(
                        text = "SUB EX ${it.examples}",
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.primary
                    )
                }
                }
                Spacer(
                    modifier = Modifier.height(15.dp)
                )

            }



        }
    }

