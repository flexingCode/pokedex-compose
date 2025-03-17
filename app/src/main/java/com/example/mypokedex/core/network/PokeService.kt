package com.example.mypokedex.core.network

import com.example.mypokedex.pokedex.data.http.responses.PokedexResponse
import com.example.mypokedex.pokemon.data.http.response.PokemonDetailResponse
import com.example.mypokedex.pokemon.data.http.response.PokemonTypeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeService {
    @GET("pokemon")
    suspend fun getPokedex():Response<PokedexResponse>

    @GET("pokemon")
    suspend fun getPokedex(@Query("offset") offset:Int, @Query("limit") limit:Int):Response<PokedexResponse>

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id:Int):Response<PokemonDetailResponse>

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name:String):Response<PokemonDetailResponse>

    @GET("type/{id}")
    suspend fun getTypeById(@Path("id") id:Int):Response<PokemonTypeResponse>

}