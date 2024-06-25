package com.example.basiccompose.compose.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basiccompose.compose.component.DefaultButton
import com.example.basiccompose.ui.theme.BasicComposeTheme


@Composable
fun ProfileVisibilitySwitches(
    updatePortfolioOpened: (Boolean) -> Unit,
    portfolioOpen: Boolean,
    updateProfileDetailsOpen: (Boolean) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        DefaultButton(text = "${if (portfolioOpen) "Close" else "Open"} portfolio", onClick = {updatePortfolioOpened(!portfolioOpen)})
        DefaultButton(text = "Show profile", onClick = {updateProfileDetailsOpen(true)})
    }
}

@Preview
@Composable
fun ProfileVisibilitySwitchesPreviewOpen() {
    BasicComposeTheme(darkTheme = false) {
        ProfileVisibilitySwitches(updatePortfolioOpened = {}, portfolioOpen = true, updateProfileDetailsOpen = {})
    }
}

@Preview
@Composable
fun ProfileVisibilitySwitchesPreviewClosed() {
    BasicComposeTheme(darkTheme = false) {
        ProfileVisibilitySwitches(updatePortfolioOpened = {}, portfolioOpen = false, updateProfileDetailsOpen = {})
    }
}
