package com.example.basiccompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.basiccompose.compose.view.MainContent
import com.example.basiccompose.compose.view.ProfileDetails
import com.example.basiccompose.compose.view.ProjectDetails
import com.example.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    /**
     * The only reason this exists is to test the Shared Transition element.
     */
    @SuppressLint("StateFlowValueCalledInComposition")
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BasicComposeTheme(darkTheme = false) {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SharedTransitionLayout {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "home"
                        ) {
                            composable("home") {
                                MainContent(
                                    projectList = mainActivityViewModel.projectList.collectAsStateWithLifecycle().value,
                                    navController = navController,
                                    sharedTransitionScope = this@SharedTransitionLayout,
                                    animatedVisibilityScope = this@composable,
                                    portfolioOpen = mainActivityViewModel.portfolioOpen,
                                    updateProfileDetailsOpen = mainActivityViewModel::updateProfileDetailsOpen,
                                    updatePortfolioOpened = mainActivityViewModel::updatePortfolioOpen
                                )
                            }
                            composable(
                                "details/{item}",
                                arguments = listOf(navArgument("item") { type = NavType.StringType })
                            ) { backStackEntry ->
                                val projectName = backStackEntry.arguments?.getString("item")!!
                                val project = mainActivityViewModel.projectList.value.first { it.projectName == projectName }
                                ProjectDetails(
                                    navController = navController,
                                    item = projectName,
                                    project = project,
                                    animatedVisibilityScope = this@composable,
                                    sharedTransitionScope = this@SharedTransitionLayout,
                                )
                            }
                        }
                    }

                    if (mainActivityViewModel.profileDetailsOpenState.collectAsStateWithLifecycle().value)
                        ProfileDetails { mainActivityViewModel.updateProfileDetailsOpen(false) }
                }
            }
        }
    }
}
