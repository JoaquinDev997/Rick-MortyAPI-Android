package com.example.rickmortyapi.ui

import android.widget.ImageView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.rickmortyapi.model.Character
import com.example.rickmortyapi.viewmodel.CharacterState
import com.example.rickmortyapi.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(viewModel: CharacterViewModel, onCharacterClick: (Character) -> Unit) {
    val state by viewModel.state.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Rick & Morty characters") }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { newText ->
                    searchQuery = newText
                    viewModel.getCharacters(newText)
                },
                label = { Text("Search character") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            when (val currentState = state) {
                is CharacterState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is CharacterState.Success -> CharacterList(currentState.characters, onCharacterClick)
                is CharacterState.Error -> ErrorView(currentState.message) { viewModel.getCharacters(searchQuery) }
            }
        }
    }
}
@Composable
fun CharacterList(characters: List<Character>, onCharacterClick: (Character) -> Unit) {
    LazyColumn {
        items(characters) { character ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onCharacterClick(character) }
            ) {
                Row(modifier = Modifier.padding(8.dp)) {
                    AndroidView(
                        factory = { context ->
                            ImageView(context).apply {
                                scaleType = ImageView.ScaleType.CENTER_CROP
                            }
                        },
                        modifier = Modifier.size(80.dp),
                        update = { imageView ->
                            Picasso.get().load(character.image).into(imageView)
                        }
                    )
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        Text(text = character.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Status: ${character.status}")
                    }
                }
            }
        }
    }
}
@Composable
fun ErrorView(message: String, onRetry: () -> Unit){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = message, color = MaterialTheme.colorScheme.error)
        Button(onClick = onRetry){ Text("Retry")}
    }
}