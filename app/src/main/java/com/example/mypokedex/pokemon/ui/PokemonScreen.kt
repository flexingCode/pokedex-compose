package com.example.mypokedex.pokemon.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypokedex.R
import com.example.mypokedex.pokedex.ui.PokedexViewModel
import com.example.mypokedex.ui.theme.Purple40

@Composable
fun PokemonScreen(
    modifier: Modifier,
    nav: NavController,
    vm: PokemonViewModel = hiltViewModel()
){
    Column(
        modifier = modifier
            .background(Purple40)
            .fillMaxSize()
    ) {
        Row {
            IconButton(
                onClick = {
                    nav.popBackStack()
                },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBackIos,
                    contentDescription = "Back button",
                    tint = Color.White
                )
            }
        }
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.poke_ball),
                contentDescription = "Poke Ball",
                modifier = Modifier
                    .size(144.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 72.dp)
                    .zIndex(2f)
            )
        }
        Column(
            modifier = Modifier
                .weight(3.5f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 64.dp, topEnd = 64.dp))
                .background(MaterialTheme.colorScheme.surface)
                .zIndex(-1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        }
    }
}
