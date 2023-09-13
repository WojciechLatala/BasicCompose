package com.example.basiccompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileDetails() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = "Wojciech L.",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(modifier = Modifier.padding(horizontal = 10.dp), text = "Android Programmer")
        Text(modifier = Modifier.padding(horizontal = 10.dp), text = "@twitterHandle", style = MaterialTheme.typography.labelMedium)
    }
}
