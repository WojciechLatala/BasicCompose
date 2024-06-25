@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.example.basiccompose.compose.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.R
import com.example.basiccompose.model.Project
import com.example.basiccompose.ui.theme.BasicComposeTheme

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ProjectsList(
    projectList: List<Project>,
    onShowDetails: (Project) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
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
            LazyColumn(contentPadding = PaddingValues(top = 5.dp, bottom = 5.dp)) {
                items(projectList) { item ->
                    ProjectCard(
                        project = item,
                        onShowDetails = onShowDetails,
                        sharedTransitionScope = sharedTransitionScope,
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProjectsListPreview() {
    BasicComposeTheme(darkTheme = false) {
        SharedTransitionLayout {
            AnimatedVisibility(visible = true) {
                ProjectsList(
                    projectList = listOf(
                        Project(
                            projectName = "Name",
                            projectIcon = R.drawable.mancity,
                            secondProjectIcon = null,
                            shortProjectDetails = "Project details",
                            longProjectDetails = ""
                        )
                    ),
                    onShowDetails = {},
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedVisibility
                )
            }
        }
    }
}
