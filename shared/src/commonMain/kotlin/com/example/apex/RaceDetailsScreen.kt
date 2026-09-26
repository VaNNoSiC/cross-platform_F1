package com.example.apex

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import apex.shared.generated.resources.Res
import apex.shared.generated.resources.back
import apex.shared.generated.resources.race_not_found

@Composable
fun RaceDetailsScreen(
    raceId: Int,
    onBack: () -> Unit
) {
    val race = races.find { it.id == raceId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (race != null) {
            Text(
                text = race.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = race.circuit,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "${race.country}, ${race.year}",
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            Text(
                text = stringResource(Res.string.race_not_found)
            )
        }

        Button(
            onClick = onBack,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text(
                text = stringResource(Res.string.back)
            )
        }
    }
}