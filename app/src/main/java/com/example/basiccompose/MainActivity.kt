package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val buttonClickedState = remember {
                mutableStateOf(false)
            }
            BasicComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                BizCardApp(buttonClickedState.value) {
                    buttonClickedState.value = it
                }
            }
        }
    }
}

@Composable
fun BizCardApp(buttonClicked: Boolean, buttonClickedEvent: (Boolean) -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Card(
            modifier = Modifier.padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider(
                    color = Color.DarkGray,
                    thickness = 2.dp
                )
                CreateInfo()
                Button(onClick = {
                    buttonClickedEvent(!buttonClicked)
                }) {
                    Text("Portfolio", style = MaterialTheme.typography.labelLarge)
                }
                if (buttonClicked) {
                    Content()
                } else {
                    Box {}
                }
            }
        }
    }
}

//@Preview
@Composable
private fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Surface(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(contentPadding = PaddingValues(top = 5.dp, bottom = 5.dp)) {
        items(data) { item ->
            ProjectCard(item)
            ProjectCard(item)
        }
    }
}

@Composable
private fun ProjectCard(item: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White)
                .padding(7.dp)
        ) {
            CreateImageProfile(modifier = Modifier.size(100.dp))
            Column(
                modifier = Modifier
                    .padding(7.dp)
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Text(text = item, fontWeight = FontWeight.Bold)
                Text(text = "A great Project", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
private fun CreateInfo() {
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

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(width = 0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_imnage), contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicComposeTheme {
        BizCardApp(true) {}
    }
}
