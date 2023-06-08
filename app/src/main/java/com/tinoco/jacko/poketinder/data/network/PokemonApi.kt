package com.tinoco.jacko.poketinder.data.network

import com.tinoco.jacko.poketinder.data.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("?Limit=20")
    suspend fun getPokemons() : Response<PokemonListResponse>
}