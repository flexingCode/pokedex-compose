package com.example.mypokedex.pokedex.ui

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.pokedex.ui.model.PokemonModel
import com.example.mypokedex.pokedex.data.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokedexRepository: PokedexRepository
): ViewModel() {
    private val _pokemonListState = MutableLiveData<PokedexScreenListState>(PokedexScreenListState.Loading)
    val pokemonListState: LiveData<PokedexScreenListState> = _pokemonListState

    private val _pokemonList = MutableLiveData<List<PokemonModel>>(emptyList())
    val pokemonList: LiveData<List<PokemonModel>> = _pokemonList

    private val _isLoadingMore = MutableLiveData(false)
    val isLoadingMore:LiveData<Boolean> = _isLoadingMore

    private val _scrollState:LazyListState = LazyListState()
    val scrollState:LazyListState = _scrollState

    init {
        getPokemonList()
    }

    private fun getPokemonList(){
       viewModelScope.launch {
           _pokemonListState.postValue(PokedexScreenListState.Loading)
           try{
               val result = pokedexRepository.getPokedex()
               if(result.results.isNotEmpty()){
                   val pokemonModuleList = result.results.map { it-> PokemonModel(it.name) }
                   _pokemonListState.postValue(PokedexScreenListState.Success(pokemonModuleList))
                   _pokemonList.postValue(pokemonModuleList)
               }else{
                   _pokemonListState.postValue(PokedexScreenListState.Error("No pokemon found"))
               }
           }catch (e: Exception){
               _pokemonListState.postValue(PokedexScreenListState.Error(e.message ?: "Unknown error"))
           }

       }
    }

    fun loadMorePokemons(){
        if(_isLoadingMore.value == true){
            return
        }
        viewModelScope.launch {
            _isLoadingMore.postValue( true )
            try{
                val result = pokedexRepository.getPokedex(offset = _pokemonList.value?.size ?: 0, limit = 20)
                val pokemonListModified = _pokemonList.value?.plus( result.results.map { it-> PokemonModel(it.name) })
                _pokemonList.postValue(pokemonListModified ?: emptyList())
                _pokemonListState.postValue(PokedexScreenListState.Success(pokemonListModified ?: emptyList()))
            }catch (e: Exception){
                _pokemonListState.postValue(PokedexScreenListState.Error(e.message ?: "Unknown error"))
                Log.e("PokemonViewModel", "Error loading more pokemons", e)
            }finally {
                _isLoadingMore.postValue(false)
            }
        }
    }

}