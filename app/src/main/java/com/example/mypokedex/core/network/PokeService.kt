package com.example.mypokedex.core.network

import com.example.mypokedex.pokedex.data.http.responses.PokedexResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

public interface PokeService {
    @GET("pokemon")
    suspend fun getPokedex():Response<PokedexResponse>

    @GET("pokemon")
    suspend fun getPokedex(@Query("offset") offset:Int, @Query("limit") limit:Int):Response<PokedexResponse>
}