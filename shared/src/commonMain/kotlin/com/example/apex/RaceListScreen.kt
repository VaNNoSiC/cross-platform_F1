package com.example.apex

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RaceListScreen(
    races: List<Race>,
    onRaceClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(races) { race ->
            RaceCard(
                race = race,
                onClick = {
                    onRaceClick(race.id)
                }
            )
        }
    }
}