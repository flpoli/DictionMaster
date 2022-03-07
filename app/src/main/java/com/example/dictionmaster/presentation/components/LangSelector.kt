package com.example.dictionmaster.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.dictionmaster.R


@Composable
fun LangSelector(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    val english = Triple<String, String, Painter>("ENGLISH", "en-gb", painterResource(R.drawable.en_icon))
    val spanish = Triple<String, String, Painter>("SPANISH", "es", painterResource(R.drawable.es_icon))
    val french = Triple<String, String, Painter>("FRENCH", "fr", painterResource(R.drawable.fr_icon))
    val selectable = listOf(english, spanish, french)

    var selectedLang by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.ArrowDropDown //it requires androidx.compose.material:material-icons-extended
    else
        Icons.Filled.ArrowDropDown


    Column() {
        TextField(
            readOnly = true,
            value = selectedLang,
            onValueChange = { selectedLang = it },
            modifier = Modifier
                .size(150.dp, 50.dp)
                .onGloballyPositioned { coordinates ->
                    textfieldSize = coordinates.size.toSize()
                },
            shape = RoundedCornerShape(100.dp),
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )

        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {

                selectable.forEach {
                    DropdownMenuItem(
                        onClick = { selectedLang = it.first }
                    ) {
                        Icon(
                            painter = it.third,
                            contentDescription = null,
                        )
                        Text(text = it.first)
                    }
                }


                }
            }


        }

