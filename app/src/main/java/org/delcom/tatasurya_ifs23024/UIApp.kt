package org.delcom.tatasurya_ifs23024

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.delcom.tatasurya_ifs23024.data.SpaceDataSource
import org.delcom.tatasurya_ifs23024.helper.RouteHelper
import org.delcom.tatasurya_ifs23024.helper.Screen
import org.delcom.tatasurya_ifs23024.ui.screens.DetailScreen
import org.delcom.tatasurya_ifs23024.ui.screens.GalaxyScreen
import org.delcom.tatasurya_ifs23024.ui.screens.HomeScreen
import org.delcom.tatasurya_ifs23024.ui.screens.SolarSystemScreen

@Composable
fun UIApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: Screen.Home.route

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToDetail = { itemId ->
                    navController.navigate(Screen.Detail.passId(itemId))
                },
                onNavigateToSolarSystem = {
                    navController.navigate(Screen.SolarSystem.route)
                },
                onNavigateToGalaxy = {
                    navController.navigate(Screen.Galaxy.route)
                },
                currentRoute = currentRoute
            )
        }

        composable(Screen.SolarSystem.route) {
            SolarSystemScreen(
                onNavigateToDetail = { itemId ->
                    navController.navigate(Screen.Detail.passId(itemId))
                },
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                onNavigateToGalaxy = {
                    navController.navigate(Screen.Galaxy.route)
                },
                currentRoute = currentRoute
            )
        }

        composable(Screen.Galaxy.route) {
            GalaxyScreen(
                onNavigateToDetail = { itemId ->
                    navController.navigate(Screen.Detail.passId(itemId))
                },
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                onNavigateToSolarSystem = {
                    navController.navigate(Screen.SolarSystem.route)
                },
                currentRoute = currentRoute
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(RouteHelper.ARG_ITEM_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt(RouteHelper.ARG_ITEM_ID) ?: -1
            val item = SpaceDataSource.getItemById(itemId)

            DetailScreen(
                item = item,
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}