package com.example.mypokedex.pokedex.domain

import com.example.mypokedex.pokedex.data.http.responses.PokedexResponse
import com.example.mypokedex.pokedex.data.repository.PokedexRepository
import javax.inject.Inject

class PokedexUsesCases @Inject constructor(
    private val pokedexRepository: PokedexRepository
){
    suspend operator fun invoke(offset: Int?, limit: Int?): PokedexResponse {
        if(offset != null && limit != null){
            return pokedexRepository.getPokedex(offset, limit)
        }else {
            return pokedexRepository.getPokedex()
        }
    }
}