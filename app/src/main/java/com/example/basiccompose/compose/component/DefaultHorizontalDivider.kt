package com.example.basiccompose.compose.component

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun DefaultHorizontalDivider(){
    HorizontalDivider(
        thickness = 2.dp,
        color = Color.DarkGray
    )
}