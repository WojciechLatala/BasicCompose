package com.example.basiccompose.repository

import com.example.basiccompose.R
import com.example.basiccompose.model.Project

class ProjectProvider() {

    fun getProjects(): List<Project> = listOf(
        Project(
            projectName = "RingRing",
            projectIcon = R.drawable.ring_ring,
            secondProjectIcon = R.drawable.ring_ring_store,
            shortProjectDetails = "Consumer and Retailer targeted Android applications",
            longProjectDetails = "Two applications working in tandem to create seamless customer experience. Retailer side of Aintu’s RingRing platform, " +
                    "“RingRing Store” is available at India’s market. Tailored to needs of users operating in demanding conditions with emphasis on ease of" +
                    " use and stability. App gives retailers the ability to advertise themselves to target audience, create promotions and loyalty programs. " +
                    "Technologies used include 2D code scanning, sound data transfer, location-based targeting. “RingRing” - Consumer side of Aintu’s RingRing" +
                    " platform. It is also aimed at India’s market. Intended to be used by general population, gives users the ability to save money by " +
                    "participating in store and brands sponsored promotions. Uses similar technologies as RingRing Store."
        ),
        Project(
            projectName = "ManCityApp",
            projectIcon = R.drawable.mancity,
            secondProjectIcon = null,
            shortProjectDetails = "Football fan Android application",
            longProjectDetails = "Football fan targeted application, providing all the necessary (and then some) features a football fans' app should have. " +
                    "Check fixtures and results of your (probably) favorite football team, read the latest news, watch videos, follow live matchday " +
                    "commentary with radio or video feed. Log in for personalized content or buy an in-app subscription for access to additional premium content.\n" +
                    "Technologies used: Koin, MVVM, Databinding."
        ),
        Project(
            projectName = "UnnamedProject",
            projectIcon = R.drawable.anon,
            secondProjectIcon = null,
            shortProjectDetails = "Android application",
            longProjectDetails = "Strict NDA signed, cannot disclose employer or app name.\n\n" +
                    "Application aimed at specific end users, not open to public. Application communicates with BT LE devices." +
                    " High emphasis on security. Responsibilities include full app development from the conception to releases.\n" +
                    "Technologies include, among others: BLE, Coroutines, Compose, Hilt."
        ),
    )
}
