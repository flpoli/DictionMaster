package com.example.dictionmaster.presentation.components

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.dictionmaster.ui.theme.LightBlue
import org.w3c.dom.Text

@Composable
fun ActionButton(
    text: String,
    onBtnClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.button
) {

    Button(
        onClick = onBtnClick,
    ) {
        Text(text = text)
    }

}