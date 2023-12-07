package com.moriawe.bottomnavbar2

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.moriawe.bottomnavbar2.navigation.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavBar(navController: NavController) {

    val items = listOf(
        BottomNavItem.Main,
        BottomNavItem.Detail,
        BottomNavItem.Mail,
        BottomNavItem.Settings
    )

    NavigationBar(
        containerColor = Color(0xFFFFFFFF),
        contentColor = Color(0xFF000000)
    ) {

        //val navBackStackEntry by navController.currentBackStackEntryAsState()
        //val currentRoute = navBackStackEntry?.destination?.route

        var selectedItemIndex by rememberSaveable() {
            mutableStateOf(0)
        }

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                label = {
                    Text(text = item.title, fontSize = 9.sp)
                },
                alwaysShowLabel = false,
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unSelectedIcon,
                            contentDescription = item.title
                        )
                    }
                })
        }

    }

}

/*
val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unSelectedIcon = Icons.Outlined.Home,
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Mail",
                        selectedIcon = Icons.Filled.Email,
                        unSelectedIcon = Icons.Outlined.Email,
                        hasNews = false,
                        badgeCount = 45
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = Icons.Filled.Settings,
                        unSelectedIcon = Icons.Outlined.Settings,
                        hasNews = true,
                    ),
 */