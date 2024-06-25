package com.example.basiccompose.model

data class Project(
    val projectName: String,
    val projectIcon: Int,
    val secondProjectIcon: Int?,
    val shortProjectDetails: String,
    val longProjectDetails: String
)
