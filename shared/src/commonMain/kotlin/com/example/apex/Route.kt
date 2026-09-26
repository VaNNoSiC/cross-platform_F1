package com.example.apex

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed interface Route : NavKey {

    @Serializable
    data object RaceList : Route

    @Serializable
    data class RaceDetails(val raceId: Int) : Route


}