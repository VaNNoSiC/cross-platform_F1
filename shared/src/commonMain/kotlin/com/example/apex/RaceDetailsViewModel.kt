package com.example.apex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apex.data.RaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class RaceDetailsUiState(
    val details: RaceDetails? = null,
    val isLoading: Boolean = false,
    val notFound: Boolean = false
)

class RaceDetailsViewModel(
    private val raceId: Int,
    private val repository: RaceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        RaceDetailsUiState(isLoading = true)
    )

    val uiState: StateFlow<RaceDetailsUiState> =
        _uiState.asStateFlow()

    init {
        loadRace()
    }

    private fun loadRace() {
        viewModelScope.launch {
            val details = repository.getRaceDetails(raceId)

            _uiState.value = if (details == null) {
                RaceDetailsUiState(
                    notFound = true
                )
            } else {
                RaceDetailsUiState(
                    details = details
                )
            }
        }
    }
}