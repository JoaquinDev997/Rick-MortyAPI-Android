package com.example.rickmortyapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickmortyapi.ui.CharacterDetailScreen
import com.example.rickmortyapi.ui.CharacterListScreen
import com.example.rickmortyapi.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "list") {
                composable("list") {
                    CharacterListScreen(
                        viewModel = viewModel,
                        onCharacterClick = { character ->
                            viewModel.selectedCharacter = character
                            navController.navigate("detail")
                        }
                    )
                }
                composable("detail") {
                    viewModel.selectedCharacter?.let { character ->
                        CharacterDetailScreen(
                            character = character,
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}