package com.example.mypokedex.pokemon.data.http.response

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    val id:Int,
    val name:String,
    val sprites:PokemonDetailSpriteResponse,
)

data class PokemonDetailSpriteResponse(
    @SerializedName("front_default")
    val default:String
)