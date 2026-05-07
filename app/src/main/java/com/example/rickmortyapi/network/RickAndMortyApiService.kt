package com.example.rickmortyapi.network

import com.example.rickmortyapi.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET ("character")
    suspend fun getCharacters(
        @Query("name") name : String = ""
    ): CharacterResponse

}