package com.example.rickmortyapi.repository

import com.example.rickmortyapi.model.CharacterResponse
import com.example.rickmortyapi.network.RetrofitClient

class CharacterRepository {

    suspend fun getCharacters(name: String): CharacterResponse {
        return RetrofitClient.apiService.getCharacters(name)
    }
}