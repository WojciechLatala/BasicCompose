package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.basiccompose.components.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //todo move to VM
            val buttonClickedState = remember {
                mutableStateOf(false)
            }

            MainScreen(buttonClickedState.value) {
                buttonClickedState.value = it
            }
        }
    }
}
