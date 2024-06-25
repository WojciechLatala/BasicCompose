@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.example.basiccompose.compose.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.basiccompose.R
import com.example.basiccompose.compose.component.DefaultButton
import com.example.basiccompose.compose.component.ProjectImage
import com.example.basiccompose.compose.component.SharedTransitionImage
import com.example.basiccompose.compose.component.SubtitleText
import com.example.basiccompose.compose.component.TitleText
import com.example.basiccompose.model.Project
import com.example.basiccompose.ui.theme.BasicComposeTheme

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ProjectDetails(
    navController: NavHostController,
    item: String,
    project: Project,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            with(sharedTransitionScope) {
                Row() {
                    SharedTransitionImage(
                        modifier = Modifier.size(120.dp),
                        animatedVisibilityScope = animatedVisibilityScope,
                        project = project
                    )
                    if (project.secondProjectIcon != null) {
                        Spacer(modifier = Modifier.width(16.dp))
                        ProjectImage(modifier = Modifier.size(120.dp), project.secondProjectIcon)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                TitleText(text = project.projectName)
                Spacer(modifier = Modifier.height(16.dp))
                SubtitleText(text = project.shortProjectDetails)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = project.longProjectDetails, style = MaterialTheme.typography.bodyMedium, color = Color.DarkGray)
            }
        }
        DefaultButton(text = "Close", onClick = { if (!navController.popBackStack()) navController.navigate("home") })
    }
}

@Preview
@Composable
fun ProjectDetailsPreview() {
    BasicComposeTheme(darkTheme = false) {
        val navController = rememberNavController()
        SharedTransitionLayout {
            AnimatedVisibility(visible = true) {
                ProjectDetails(
                    navController = navController,
                    item = "Name",
                    project = Project(
                        projectName = "Name",
                        projectIcon = R.drawable.mancity,
                        secondProjectIcon = R.drawable.mancity,
                        shortProjectDetails = "Project details",
                        longProjectDetails = "Long project deets lorem ipsum des dolores des diablo"
                    ),
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedVisibility
                )
            }
        }
    }
}
