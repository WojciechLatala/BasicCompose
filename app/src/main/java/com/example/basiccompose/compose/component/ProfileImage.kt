package com.example.basiccompose.compose.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme

@Composable
fun ProfileImage() {
    Surface(
        modifier = Modifier.size(140.dp).padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(width = 0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(widthDp = 300, heightDp = 300)
@Composable
fun ImageProfilePreview() {
    BasicComposeTheme {
        ProfileImage()
    }
}
