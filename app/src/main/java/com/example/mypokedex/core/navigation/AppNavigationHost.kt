package com.example.mypokedex.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mypokedex.pokedex.ui.Home
import com.example.mypokedex.profile.ui.Profile

@Composable
fun AppNavigationHost(nav: NavHostController, modifier: Modifier){
    NavHost(
        navController = nav,
        startDestination = AppBottomNavigation.Pokedex.route,
    ){
        homeGraph(nav, modifier)
        profileGraph(nav, modifier)
    }
}

fun NavGraphBuilder.homeGraph(navController:NavController, modifier: Modifier){
    navigation(startDestination = "home_screen", route = AppBottomNavigation.Pokedex.route){
        composable("home_screen"){
            Home(modifier, navController)
        }
    }
}

fun NavGraphBuilder.profileGraph(navController:NavController, modifier: Modifier){
    navigation(startDestination = "profile_screen", route = AppBottomNavigation.Profile.route) {
        composable("profile_screen") {
            Profile(modifier, navController)
        }
    }
}

