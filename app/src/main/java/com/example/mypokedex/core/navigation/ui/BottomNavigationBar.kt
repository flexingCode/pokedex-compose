package com.example.mypokedex.core.navigation.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mypokedex.core.navigation.AppBottomNavigation

@Composable
fun BottomNavigationBar(routes:List<AppBottomNavigation>, navController: NavHostController){
    NavigationBar {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = backStackEntry?.destination

        routes.forEach{ route ->
            NavigationBarItem(
                icon = { Icon(route.icon, contentDescription = null)},
                label = { Text(route.label) },
                selected = currentDestination?.hierarchy?.any {it.route == route.route} == true,
                onClick = {
                    navController.navigate(route.route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}