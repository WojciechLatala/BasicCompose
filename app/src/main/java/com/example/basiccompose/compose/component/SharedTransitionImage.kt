package com.example.basiccompose.compose.component

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.basiccompose.model.Project

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.SharedTransitionImage(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    project: Project
) {
    ProjectImage(
        modifier = modifier
            .sharedElement(
                rememberSharedContentState(key = "image${project.projectName}"),
                animatedVisibilityScope = animatedVisibilityScope
            ),
        projectIcon = project.projectIcon,
    )
}

@Composable
fun ProjectImage(
    modifier: Modifier = Modifier,
    projectIcon: Int
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = projectIcon), contentDescription = "project image",
        contentScale = ContentScale.Crop
    )
}
