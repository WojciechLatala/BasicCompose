package com.example.basiccompose.compose.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.basiccompose.compose.component.DefaultButton
import com.example.basiccompose.compose.component.DefaultHorizontalDivider
import com.example.basiccompose.compose.component.ProfileDetailsCategoryText
import com.example.basiccompose.compose.component.ProfileDetailsContentText
import com.example.basiccompose.ui.theme.BasicComposeTheme

/**
 * Profile details are in a dialog, because I wanted to create a compose dialog ¯\_(ツ)_/¯ They would probably work better in a separate screen.
 * TODO reorder and redesign this view, find some way to include also the details of the positions.
 */
@Composable
fun ProfileDetails(closeProfileDetails: () -> Unit) {
    Dialog(
        onDismissRequest = { closeProfileDetails() },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            ) {
                Signature(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                DefaultHorizontalDivider()
                Spacer(modifier = Modifier.height(16.dp))
                ProfileDetailsCategoryText("Education")
                ProfileDetailsContentText(
                    text = "2010 - 2015 Wrocław University of Economics\n" +
                            "Master’s Degree in Computer Science and Econometrics\n" +
                            "Major: IT Services, Decision making methods and systems"
                )
                Spacer(modifier = Modifier.height(16.dp))
                DefaultHorizontalDivider()
                Spacer(modifier = Modifier.height(16.dp))
                ProfileDetailsCategoryText("Experience")
                ProfileDetailsContentText(
                    "2023.10 – present\n" +
                            "Anonymous Company"
                )
//                        "Mobile Android Developer\n" +
//                        "Strict NDA signed; cannot disclose company name, can give contact information after previous confirmation with employer. Current responsibilities: Full development of Android mobile app. It is delivered to specific users (not available on Google Play Store), used")

                ProfileDetailsContentText(
                    "2019.10 – 2024.04\n" +
                            "Intive, GmbH."
                )
//                        "Mobile Android Developer\n" +
//                        "Mobile Android developer responsible for development of multi-purpose application.\n" +
//                        "Collaborating with multi-national teams to define and ship new features.\n" +
//                        "Delivering stable, testable solutions, monitored with various analytical tools. Overseeing Play Store releases, maintaining and optimizing legacy code.")

                ProfileDetailsContentText(
                    "2016.03 – 2019.10\n" +
                            "Aintu, inc."
                )
//                        "Mobile Applications Developer\n" +
//                        "Mobile developer involved in creating and maintaining Android Mobile Applications. Focused on providing easily scalable, efficient, and stable solutions. Experience in working with an international")

                ProfileDetailsContentText(
                    "2015.01 – 2016.03\n" +
                            "Sophscope, Sp. z.o.o."
                )
//                        "Developer\n" +
//                        "Full-time .NET, .NET Xamarin mobile application, SAP ABAP developer. Involved in projects for companies such as DB Schenker, Libet or Tauron. Responsible for development and maintaining both Backend and Frontend.")
                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    DefaultButton(modifier = Modifier.align(Alignment.Center), text = "Close") { closeProfileDetails() }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileDetailsDialogPreview() {
    BasicComposeTheme(darkTheme = false) {
        ProfileDetails({})
    }
}
