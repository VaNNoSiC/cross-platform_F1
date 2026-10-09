package com.example.apex

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import f1archive.shared.generated.resources.Res
import f1archive.shared.generated.resources.nothing_found
import f1archive.shared.generated.resources.search_races
import f1archive.shared.generated.resources.loading
@Composable
fun RaceListScreen(
    state: RaceListUiState,
    onSearchQueryChange: (String) -> Unit,
    onRaceClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = onSearchQueryChange,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(
                        Res.string.search_races
                    )
                )
            },
            singleLine = true
        )

        if (state.isLoading) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(Res.string.loading)
                )
            }
        } else if (state.filteredRaces.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(Res.string.nothing_found)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(
                    items = state.filteredRaces,
                    key = { it.id }
                ) { race ->
                    RaceCard(
                        race = race,
                        onClick = {
                            onRaceClick(race.id)
                        }
                    )
                }
            }
        }
    }
}