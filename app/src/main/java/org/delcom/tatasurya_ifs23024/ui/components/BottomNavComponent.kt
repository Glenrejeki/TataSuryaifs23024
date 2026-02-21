package org.delcom.tatasurya_ifs23024.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.delcom.tatasurya_ifs23024.R
import org.delcom.tatasurya_ifs23024.helper.Screen

sealed class BottomNavItem(
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val titleResId: Int
) {
    object Home : BottomNavItem(Screen.Home.route, Icons.Default.Home, R.string.home)
    object SolarSystem : BottomNavItem(Screen.SolarSystem.route, Icons.Default.Star, R.string.solar_system)
    object Galaxy : BottomNavItem(Screen.Galaxy.route, Icons.Default.Info, R.string.galaxy)
}

@Composable
fun BottomNavComponent(
    currentRoute: String,
    onItemSelected: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.SolarSystem,
        BottomNavItem.Galaxy
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.titleResId)
                    )
                },
                label = {
                    Text(text = stringResource(item.titleResId))
                }
            )
        }
    }
}