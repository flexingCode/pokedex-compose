package com.example.mypokedex.pokemon.ui.model

data class PokemonModel(
    val id:Int,
    val name:String,
    val image:String,
    val height:Float,
    val weight:Float,
    val types:List<PokemonTypeModel>
)

data class PokemonTypeModel(
    val id:Int,
    val name:String,
    val image:String
)