package com.example.mypokedex.pokedex.data.repository
import com.example.mypokedex.pokedex.data.http.responses.PokedexResponse
import com.example.mypokedex.pokedex.data.service.PokedexService
import javax.inject.Inject

class PokedexRepository @Inject constructor(
     private val pokedexService: PokedexService
){
    suspend fun getPokedex(): PokedexResponse{
        return pokedexService.getPokedex()
    }

    suspend fun getPokedex(offset: Int, limit: Int): PokedexResponse{
        return pokedexService.getPokedex(offset, limit)
    }
}