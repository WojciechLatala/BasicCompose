@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.example.basiccompose.compose.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.basiccompose.R
import com.example.basiccompose.model.Project
import com.example.basiccompose.ui.theme.BasicComposeTheme

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainContent(
    projectList: List<Project>,
    navController: NavHostController,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    portfolioOpen: Boolean,
    updateProfileDetailsOpen: (Boolean) -> Unit,
    updatePortfolioOpened: (Boolean) -> Unit,
) {
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
            ProfileHeader()
            ProfileVisibilitySwitches(
                updatePortfolioOpened = updatePortfolioOpened,
                portfolioOpen = portfolioOpen,
                updateProfileDetailsOpen = updateProfileDetailsOpen
            )
            AnimatedVisibility(visible = portfolioOpen) {
                ProjectsList(
                    projectList = projectList,
                    onShowDetails = { navController.navigate("details/${it.projectName}") },
                    sharedTransitionScope = sharedTransitionScope,
                    animatedVisibilityScope = animatedVisibilityScope,
                )
            }
        }
    }
}

@Preview
@Composable
fun MainContentPreview() {
    BasicComposeTheme(darkTheme = false) {
        val navController = rememberNavController()
        SharedTransitionLayout {
            AnimatedVisibility(visible = true) {
                MainContent(
                    projectList = listOf(
                        Project(
                            projectName = "Name",
                            projectIcon = R.drawable.mancity,
                            secondProjectIcon = null,
                            longProjectDetails = "ManCityApp long project deets",
                            shortProjectDetails = "Project details"
                        )
                    ),
                    navController = navController,
                    portfolioOpen = true,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedVisibility,
                    updateProfileDetailsOpen = {},
                    updatePortfolioOpened = {},
                )
            }
        }
    }
}
