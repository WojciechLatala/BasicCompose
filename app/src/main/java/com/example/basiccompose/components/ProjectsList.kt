package com.example.basiccompose.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun ProjectsList(data: List<String>) {
    LazyColumn(contentPadding = PaddingValues(top = 5.dp, bottom = 5.dp)) {
        items(data) { item ->
            ProjectCard(item)
        }
    }
}