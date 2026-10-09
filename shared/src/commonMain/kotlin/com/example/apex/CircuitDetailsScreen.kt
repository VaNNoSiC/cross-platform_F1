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
import f1archive.shared.generated.resources.city
import f1archive.shared.generated.resources.circuit_not_found
import f1archive.shared.generated.resources.country
import f1archive.shared.generated.resources.loading

@Composable
fun CircuitDetailsScreen(
    state: CircuitDetailsUiState,
    onBack: () -> Unit
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
                    text = stringResource(
                        Res.string.loading
                    )
                )
            }

            state.notFound -> {
                Text(
                    text = stringResource(
                        Res.string.circuit_not_found
                    )
                )
            }

            state.circuit != null -> {
                val circuit = state.circuit

                Text(
                    text = circuit.name,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "${stringResource(Res.string.city)}: " +
                            circuit.city,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(
                    text = "${stringResource(Res.string.country)}: " +
                            circuit.country
                )
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