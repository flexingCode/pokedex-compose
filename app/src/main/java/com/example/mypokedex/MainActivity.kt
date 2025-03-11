package com.example.mypokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mypokedex.core.navigation.AppBottomNavigation
import com.example.mypokedex.core.navigation.AppNavigationHost
import com.example.mypokedex.core.navigation.ui.BottomNavigationBar
import com.example.mypokedex.ui.theme.MyPokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPokedexTheme {
                Main()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun Main(){
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomNavigationBar(listOf(
                AppBottomNavigation.Pokedex,
                AppBottomNavigation.Profile
            ),navController)
        }, content = {
            AppNavigationHost(navController,Modifier.padding(it))
        }
    )
}