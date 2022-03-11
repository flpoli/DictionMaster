package com.example.dictionmaster.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictionmaster.R
import com.example.dictionmaster.presentation.search.SearchViewModel


@Composable
fun LangSelector(
    languages: List<String>,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val disabledValue: String = ""
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
    ) {

//        Image(
//            painter = languages.get(selectedIndex),
//            contentDescription = "lang icon"
//        )

        Text(
            text = languages[selectedIndex],
            textAlign = TextAlign.Center,
            modifier = Modifier
                .size(130.dp, 38.dp)
                .clickable(
                    onClick = {
                        expanded = true
                    })
                .background(
                    color = MaterialTheme.colors.secondaryVariant,
                    shape = RoundedCornerShape(80.dp)
                )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .size(130.dp, 160.dp)
                .background(
                    color = MaterialTheme.colors.secondaryVariant,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            languages.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    viewModel.onLangSelected(languages[index])
                    selectedIndex = index
                    expanded = false
                }) {
                    val disabledText = if (s == disabledValue) {
                        " (Disabled)"
                    } else {
                        ""
                    }
                    Text(
                        text = s + disabledText,
                        textAlign = TextAlign.Center)
                }
            }
        }
    }
}


