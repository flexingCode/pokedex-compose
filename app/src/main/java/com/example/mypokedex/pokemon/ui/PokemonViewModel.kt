package com.example.mypokedex.pokemon.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.pokemon.domain.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonUserCase:GetPokemonDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val pokemonId: String = savedStateHandle["pokemonId"] ?: ""

    init {
        getPokemonDetails()
    }

    private fun getPokemonDetails(){
        viewModelScope.launch {
            val pokemonData = pokemonUserCase(pokemonId.toInt())
            Log.d("PokemonViewModel", "Pokemon data: ${pokemonData.toString()}")
        }
    }
}