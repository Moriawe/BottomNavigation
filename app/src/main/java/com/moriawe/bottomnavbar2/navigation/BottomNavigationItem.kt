package com.moriawe.bottomnavbar2.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

sealed class BottomNavItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
) {
    object Main: BottomNavItem(
        title = "Home",
        route = "main_screen",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        hasNews = false
    )
    object Detail: BottomNavItem(
        title = "Detail",
        route = "detail_screen",
        selectedIcon = Icons.Filled.List,
        unSelectedIcon = Icons.Outlined.List,
        hasNews = false
    )
    object Mail: BottomNavItem(
        title = "Mail",
        route = "mail_screen",
        selectedIcon = Icons.Filled.Email,
        unSelectedIcon = Icons.Outlined.Email,
        hasNews = false,
        badgeCount = 11
    )
    object Settings: BottomNavItem(
        title = "Settings",
        route = "settings_screen",
        selectedIcon = Icons.Filled.Settings,
        unSelectedIcon = Icons.Outlined.Settings,
        hasNews = true)

    /*
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }

     */
}