package com.example.dictionmaster.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.dictionmaster.ui.theme.LightBlue
import org.w3c.dom.Text

@Composable
fun ActionButton(
    text: String,
    onBtnClick: () -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.button
) {

    Button(
        onClick = onBtnClick,
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = text)
    }

}