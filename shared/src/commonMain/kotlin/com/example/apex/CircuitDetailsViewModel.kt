package com.example.apex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apex.data.RaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class CircuitDetailsUiState(
    val circuit: Circuit? = null,
    val isLoading: Boolean = false,
    val notFound: Boolean = false
)

class CircuitDetailsViewModel(
    private val circuitId: Int,
    private val repository: RaceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        CircuitDetailsUiState(
            isLoading = true
        )
    )

    val uiState: StateFlow<CircuitDetailsUiState> =
        _uiState.asStateFlow()

    init {
        loadCircuit()
    }

    private fun loadCircuit() {
        viewModelScope.launch {
            val circuit = repository.getCircuit(circuitId)

            _uiState.value = if (circuit == null) {
                CircuitDetailsUiState(
                    notFound = true
                )
            } else {
                CircuitDetailsUiState(
                    circuit = circuit
                )
            }
        }
    }
}