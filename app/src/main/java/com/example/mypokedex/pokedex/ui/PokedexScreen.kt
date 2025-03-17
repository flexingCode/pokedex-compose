package com.example.mypokedex.pokedex.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypokedex.pokedex.ui.components.PokedexHeader
import com.example.mypokedex.pokedex.ui.components.PokedexItem
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce

@OptIn(FlowPreview::class)
@Composable
fun Home(
    modifier: Modifier,
    nav:NavController,
    vm:PokedexViewModel = hiltViewModel()
){
    val pokedexState by vm.pokemonListState.observeAsState(initial = PokedexScreenListState.Loading)
    val isLoadingMore by vm.isLoadingMore.observeAsState(initial = false)

    LaunchedEffect(vm.scrollState) {
        snapshotFlow { vm.scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .debounce(500L)
            .collectLatest { lastVisibleIndex ->
                if (lastVisibleIndex != null && lastVisibleIndex >= (vm.pokemonList.value?.size ?: 0) - 1 && vm.isLoadingMore.value == false) {
                    vm.loadMorePokemons()
                }
            }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        PokedexHeader()
        when(val state = pokedexState){
            is PokedexScreenListState.Success -> {
                LazyColumn(
                    modifier = Modifier.padding(start = 16.dp),
                    state = vm.scrollState
                ) {
                    state.pokemonList.forEach { pokemon ->
                        item {
                            PokedexItem(name = pokemon.name){
                                nav.navigate("pokemon_screen/${pokemon.id}")
                            }
                        }
                    }
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.BottomCenter

                        ){
                            if(isLoadingMore) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }

                    }
                }

            }
            is PokedexScreenListState.Error -> {
                Column {
                    Text(text = "Error: ${state.message}")
                }
            }
            PokedexScreenListState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}