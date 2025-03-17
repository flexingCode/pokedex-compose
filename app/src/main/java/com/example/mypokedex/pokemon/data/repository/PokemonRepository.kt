package com.example.mypokedex.pokemon.data.repository

import com.example.mypokedex.core.utilities.UriUtilities
import com.example.mypokedex.pokemon.data.http.response.PokemonDetailResponse
import com.example.mypokedex.pokemon.data.service.PokemonService
import com.example.mypokedex.pokemon.data.service.TypeService
import com.example.mypokedex.pokemon.ui.model.PokemonModel
import com.example.mypokedex.pokemon.ui.model.PokemonTypeModel
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val typeService: TypeService
){
    suspend fun getPokemonById(id:Int):PokemonModel{
        val pokemonData = pokemonService.getPokemonById(id)
        val pokemonTypes = mutableListOf<PokemonTypeModel>()
        pokemonData.types.forEach{
            val typeData = typeService.getTypeById(UriUtilities.getIdFromUri(it.type.url))
            pokemonTypes.add(
                PokemonTypeModel(
                    typeData.id,
                    typeData.name,
                    typeData.sprites.generationIII.emerald.sprite
                )
            )
        }
        return PokemonModel(
            id = pokemonData.id,
            name = pokemonData.name,
            image = pokemonData.sprites.default,
            types = pokemonTypes,
            height = pokemonData.height,
            weight = pokemonData.weight
        )
    }


}