package com.example.basiccompose.compose.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.R
import com.example.basiccompose.compose.component.SharedTransitionImage
import com.example.basiccompose.model.Project
import com.example.basiccompose.ui.theme.BasicComposeTheme

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ProjectCard(
    project: Project,
    onShowDetails: (Project) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = LocalIndication.current,
            ) {
                onShowDetails(project)
            },
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        with(sharedTransitionScope) {
            Row(modifier = Modifier.padding(16.dp)) {
                SharedTransitionImage(
                    modifier = Modifier.size(80.dp),
                    animatedVisibilityScope = animatedVisibilityScope,
                    project = project
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                ) {
                    Text(text = project.projectName, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    Text(text = project.shortProjectDetails, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Preview
@Composable
fun ProjectCardPreview() {
    BasicComposeTheme(darkTheme = false) {
        SharedTransitionLayout {
            AnimatedVisibility(visible = true) {
                ProjectCard(
                    project = Project(
                        projectName = "Name",
                        projectIcon = R.drawable.mancity,
                        secondProjectIcon = null,
                        shortProjectDetails = "Project details",
                        longProjectDetails = "long project deets"
                    ),
                    onShowDetails = {},
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedVisibility
                )
            }
        }
    }
}
