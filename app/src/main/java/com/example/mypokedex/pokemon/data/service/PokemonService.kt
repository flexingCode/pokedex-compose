package com.example.mypokedex.pokemon.data.service

import coil3.network.HttpException
import coil3.network.NetworkResponse
import com.example.mypokedex.core.network.PokeService
import com.example.mypokedex.pokemon.data.http.response.PokemonDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonService @Inject constructor(
    private val pokeService:PokeService
){
    suspend fun getPokemonById(id:Int):PokemonDetailResponse{
        return withContext(Dispatchers.IO){
            val response = pokeService.getPokemonById(id)
            if(response.isSuccessful){
                response.body()!!
            }else{
                throw HttpException(NetworkResponse(
                    code = response.code(),
                ))
            }
        }
    }
}