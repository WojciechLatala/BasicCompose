package com.example.basiccompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.basiccompose.model.Project
import com.example.basiccompose.repository.ProjectProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainActivityViewModel : ViewModel() {

    private val projectRepository = ProjectProvider()

    private val _profileDetailsOpenState = MutableStateFlow(false)
    val profileDetailsOpenState: StateFlow<Boolean> = _profileDetailsOpenState.asStateFlow()

    fun updateProfileDetailsOpen(value: Boolean) {
        _profileDetailsOpenState.update { value }
    }

    var portfolioOpen by mutableStateOf(false)
        private set

    fun updatePortfolioOpen(value: Boolean) {
        portfolioOpen = value
    }

    private val _projectList: MutableStateFlow<List<Project>> = MutableStateFlow(projectRepository.getProjects())
    val projectList: StateFlow<List<Project>> = _projectList.asStateFlow()
}
