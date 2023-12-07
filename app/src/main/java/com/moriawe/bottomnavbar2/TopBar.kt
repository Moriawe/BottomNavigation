package com.moriawe.bottomnavbar2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFFFFFFFF),
            titleContentColor = Color(0xFF000000)
        ),
        title = {
            Text(title)
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* Do something */ }) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Do something */ }) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            }
        }
    )
}