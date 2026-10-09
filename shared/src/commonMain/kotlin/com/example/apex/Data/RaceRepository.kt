package com.example.apex.data

import com.example.apex.Circuit
import com.example.apex.Driver
import com.example.apex.Race
import com.example.apex.RaceDetails

interface RaceRepository {

    suspend fun getRaces(): List<Race>

    suspend fun getRaceDetails(id: Int): RaceDetails?

    suspend fun getCircuit(id: Int): Circuit?

    suspend fun getDrivers(): List<Driver>
}