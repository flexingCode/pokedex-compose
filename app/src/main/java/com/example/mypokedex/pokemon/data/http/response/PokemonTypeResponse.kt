package com.example.mypokedex.pokemon.data.http.response

import com.google.gson.annotations.SerializedName

data class PokemonTypeResponse(
    val id:Int,
    val name:String,
    val sprites:PokemonTypeSpriteResponse
)

data class PokemonTypeSpriteResponse(
    @SerializedName("generation-iii")
    val generationIII:PokemonGenerationTypeResponse
)

data class PokemonGenerationTypeResponse(
    val emerald:GenerationTypeSpriteResponse
)

data class GenerationTypeSpriteResponse(
    @SerializedName("name_icon")
    val sprite:String

)