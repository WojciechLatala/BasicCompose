package com.example.basiccompose.compose.component

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basiccompose.ui.theme.BasicComposeTheme

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(modifier = modifier, onClick = {
        onClick.invoke()
    }) {
        Text(text, style = MaterialTheme.typography.labelLarge)
    }
}


@Preview
@Composable
fun DefaultButtonPreview() {
    BasicComposeTheme(darkTheme = false) {
        DefaultButton(text = "Button text", onClick = {})
    }
}
