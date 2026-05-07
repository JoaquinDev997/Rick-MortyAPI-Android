package com.example.rickmortyapi.model


data class CharacterResponse(
    val results: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
    val species: String,
    val gender: String
)