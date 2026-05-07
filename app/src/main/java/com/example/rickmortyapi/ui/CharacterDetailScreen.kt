package com.example.rickmortyapi.ui

import android.widget.ImageView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.rickmortyapi.model.Character
import com.squareup.picasso.Picasso
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(character: Character, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    Button(onClick = onBackClick) {
                        Text("< Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = character.name,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            AndroidView(
                factory = { context ->
                    ImageView(context).apply {
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }
                },
                modifier = Modifier.size(300.dp),
                update = { imageView ->
                    Picasso.get().load(character.image).into(imageView)
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Name: ${character.name}", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Status: ${character.status}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Species: ${character.species}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Gender: ${character.gender}", style = MaterialTheme.typography.titleLarge)
        }
    }
}