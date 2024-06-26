package com.example.basiccompose.compose.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileDetailsContentText(text: String) {
    Text(modifier = Modifier.padding(vertical = 6.dp), text = text, style = MaterialTheme.typography.bodyMedium)
}
