package com.example.mypokedex.pokedex.data.service

import com.example.mypokedex.core.network.PokeService
import com.example.mypokedex.pokedex.data.http.responses.PokedexResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokedexService @Inject constructor(
    private val pokedexService: PokeService
) {

    suspend fun getPokedex (): PokedexResponse {
        return withContext(Dispatchers.IO){
            val response = pokedexService.getPokedex()
            if(response.isSuccessful){
                response.body()!!
            }else{
                PokedexResponse(
                    count = 0,
                    next = "",
                    previous = "",
                    results = emptyList()
                )
            }
        }
    }

    suspend fun getPokedex(offset: Int, limit: Int): PokedexResponse {
        return withContext(Dispatchers.IO){
            val response = pokedexService.getPokedex(offset, limit)
            if(response.isSuccessful){
                response.body()!!
            }else{
                PokedexResponse(
                    count = 0,
                    next = "",
                    previous = "",
                    results = emptyList()
                )
            }
        }
    }
}