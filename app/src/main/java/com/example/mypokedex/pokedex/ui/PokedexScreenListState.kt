package com.example.mypokedex.pokedex.ui

import com.example.mypokedex.pokedex.ui.model.PokemonModel

sealed class PokedexScreenListState {
    object Loading : PokedexScreenListState()
    data class Success(val pokemonList: List<PokemonModel>) : PokedexScreenListState()
    data class Error(val message: String) : PokedexScreenListState()
}