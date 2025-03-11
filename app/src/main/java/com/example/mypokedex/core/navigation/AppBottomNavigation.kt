package com.example.mypokedex.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppBottomNavigation (val route:String, val label:String, val icon:ImageVector){
    data object Pokedex : AppBottomNavigation("pokedex", "Pokedex", Icons.Default.Home)
    data object Profile : AppBottomNavigation("profile", "Profile", Icons.Default.Person)
}