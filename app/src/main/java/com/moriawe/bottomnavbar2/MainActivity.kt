package com.moriawe.bottomnavbar2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.moriawe.bottomnavbar2.navigation.NavigationGraph
import com.moriawe.bottomnavbar2.ui.theme.BottomNavbar2Theme


class MainActivity() : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            BottomNavbar2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopBar("Header")
                        },
                        bottomBar = {
                            BottomNavBar(navController)
                        },
                    ) { innerPadding ->
                        NavigationGraph(navController, innerPadding)
                    }
                }
            }
        }
    }
}
