package com.example.rickmortyapi.viewmodel

import com.example.rickmortyapi.model.Character

sealed class CharacterState {

    object Loading : CharacterState()
    data class Success(val characters: List<Character>) : CharacterState()
    data class Error(val message: String) : CharacterState()
}
