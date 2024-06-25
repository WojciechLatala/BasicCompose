package com.example.basiccompose.compose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.compose.component.TitleText
import com.example.basiccompose.ui.theme.BasicComposeTheme

@Composable
fun Signature(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        TitleText(text = "Wojciech Latała")
        Text(text = "Android Programmer")
    }
}

@Preview
@Composable
fun SignaturePreview() {
    BasicComposeTheme(darkTheme = false) {
        Signature(modifier = Modifier.background(Color.White))
    }
}
