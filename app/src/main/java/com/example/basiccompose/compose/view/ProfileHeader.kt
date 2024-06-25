package com.example.basiccompose.compose.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.compose.component.DefaultHorizontalDivider
import com.example.basiccompose.compose.component.ProfileImage
import com.example.basiccompose.ui.theme.BasicComposeTheme

@Composable
fun ProfileHeader(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.height(10.dp))
        DefaultHorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))
        Signature()
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview
@Composable
fun ProfileHeaderPreview(){
    BasicComposeTheme(darkTheme = false) {
        ProfileHeader()
    }
}
