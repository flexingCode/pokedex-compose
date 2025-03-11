package com.example.mypokedex.pokedex.data.http.responses

data class PokedexResponse (
    val count: Int,
    val next:String?,
    val previous:String?,
    val results:List<PokemonInfoResponse>
)

data class PokemonInfoResponse(
    val name:String,
    val url:String
)