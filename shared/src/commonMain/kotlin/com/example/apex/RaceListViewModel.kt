package com.example.apex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apex.data.RaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class RaceListUiState(
    val races: List<Race> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = false
) {
    val filteredRaces: List<Race>
        get() {
            if (searchQuery.isBlank()) {
                return races
            }

            return races.filter { race ->
                race.name.contains(
                    searchQuery,
                    ignoreCase = true
                ) ||
                        race.circuitName.contains(
                            searchQuery,
                            ignoreCase = true
                        ) ||
                        race.country.contains(
                            searchQuery,
                            ignoreCase = true
                        ) ||
                        race.city.contains(
                            searchQuery,
                            ignoreCase = true
                        )
            }
        }
}

class RaceListViewModel(
    private val repository: RaceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        RaceListUiState(isLoading = true)
    )

    val uiState: StateFlow<RaceListUiState> =
        _uiState.asStateFlow()

    init {
        loadRaces()
    }

    private fun loadRaces() {
        viewModelScope.launch {
            val races = repository.getRaces()

            _uiState.value = RaceListUiState(
                races = races
            )
        }
    }

    fun onSearchQueryChange(query: String) {
        _uiState.value = _uiState.value.copy(
            searchQuery = query
        )
    }
}