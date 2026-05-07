package com.example.rickmortyapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmortyapi.model.Character
import com.example.rickmortyapi.network.RetrofitClient
import com.example.rickmortyapi.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val repository = CharacterRepository()

    private val _state = MutableStateFlow<CharacterState>(CharacterState.Loading)
    val state: StateFlow<CharacterState> = _state

    var selectedCharacter: Character? = null

    init {
        getCharacters()
    }

    fun getCharacters(name: String = "") {
        viewModelScope.launch {
            _state.value = CharacterState.Loading
            try {
                val response = repository.getCharacters(name)
                _state.value = CharacterState.Success(response.results)
            } catch (e: Exception) {
                _state.value = CharacterState.Error(e.message ?: "Error desconocido")
            }
        }
    }
}