package com.example.mypokedex.pokemon.domain

import com.example.mypokedex.pokemon.data.repository.PokemonRepository
import com.example.mypokedex.pokemon.ui.model.PokemonModel
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    suspend operator fun invoke(id:Int):PokemonModel{
        return pokemonRepository.getPokemonById(id)
    }
}