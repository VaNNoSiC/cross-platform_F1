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
import f1archive.shared.generated.resources.Res
import f1archive.shared.generated.resources.back
import f1archive.shared.generated.resources.circuit
import f1archive.shared.generated.resources.city
import f1archive.shared.generated.resources.country
import f1archive.shared.generated.resources.date
import f1archive.shared.generated.resources.drivers
import f1archive.shared.generated.resources.open_circuit
import f1archive.shared.generated.resources.race_not_found
import f1archive.shared.generated.resources.stage
import f1archive.shared.generated.resources.loading
@Composable
fun RaceDetailsScreen(
    state: RaceDetailsUiState,
    onBack: () -> Unit,
    onCircuitClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        when {
            state.isLoading -> {
                Text(
                    text = stringResource(Res.string.loading)
                )
            }

            state.notFound -> {
                Text(
                    text = stringResource(
                        Res.string.race_not_found
                    )
                )
            }

            state.details != null -> {
                val details = state.details

                Text(
                    text = details.race.name,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "${stringResource(Res.string.stage)}: " +
                            details.race.round
                )

                Text(
                    text = "${stringResource(Res.string.date)}: " +
                            details.race.date
                )

                Text(
                    text = "${stringResource(Res.string.city)}: " +
                            details.race.city
                )

                Text(
                    text = "${stringResource(Res.string.country)}: " +
                            details.race.country
                )

                Text(
                    text = "${stringResource(Res.string.circuit)}: " +
                            details.circuit.name
                )

                Button(
                    onClick = {
                        onCircuitClick(details.circuit.id)
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(
                        text = stringResource(
                            Res.string.open_circuit
                        )
                    )
                }

                Text(
                    text = stringResource(
                        Res.string.drivers
                    ),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 24.dp)
                )

                details.drivers.forEach { driver ->
                    Text(
                        text = "#${driver.number} " +
                                "${driver.firstName} ${driver.lastName}"
                    )
                }
            }
        }

        Button(
            onClick = onBack,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text(
                text = stringResource(
                    Res.string.back
                )
            )
        }
    }
}