package com.example.mypokedex.pokemon.data.http.response

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    val id:Int,
    val name:String,
    val height:Float,
    val weight:Float,
    val sprites:PokemonDetailSpriteResponse,
    val types:List<PokemonDatailTypeResponse>
)

data class PokemonDetailSpriteResponse(
    @SerializedName("front_default")
    val default:String
)
data class PokemonDatailTypeResponse(
    val slot:Int,
    val type:PokemonDatailTypeDetailResponse
)

data class PokemonDatailTypeDetailResponse(
    val name:String,
    val url:String
)