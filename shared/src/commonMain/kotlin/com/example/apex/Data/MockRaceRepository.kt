package com.example.apex.data

import com.example.apex.Circuit
import com.example.apex.Driver
import com.example.apex.Race
import com.example.apex.RaceDetails

class MockRaceRepository : RaceRepository {

    private val circuits = listOf(
        Circuit(
            id = 1,
            name = "Bahrain International Circuit",
            city = "Sakhir",
            country = "Bahrain"
        ),
        Circuit(
            id = 2,
            name = "Jeddah Corniche Circuit",
            city = "Jeddah",
            country = "Saudi Arabia"
        ),
        Circuit(
            id = 3,
            name = "Albert Park Circuit",
            city = "Melbourne",
            country = "Australia"
        ),
        Circuit(
            id = 4,
            name = "Suzuka International Racing Course",
            city = "Suzuka",
            country = "Japan"
        ),
        Circuit(
            id = 5,
            name = "Circuit de Monaco",
            city = "Monte Carlo",
            country = "Monaco"
        ),
        Circuit(
            id = 6,
            name = "Circuit Gilles Villeneuve",
            city = "Montreal",
            country = "Canada"
        ),
        Circuit(
            id = 7,
            name = "Circuit de Barcelona-Catalunya",
            city = "Barcelona",
            country = "Spain"
        ),
        Circuit(
            id = 8,
            name = "Red Bull Ring",
            city = "Spielberg",
            country = "Austria"
        ),
        Circuit(
            id = 9,
            name = "Silverstone Circuit",
            city = "Silverstone",
            country = "United Kingdom"
        ),
        Circuit(
            id = 10,
            name = "Circuit de Spa-Francorchamps",
            city = "Spa",
            country = "Belgium"
        ),
        Circuit(
            id = 11,
            name = "Hungaroring",
            city = "Budapest",
            country = "Hungary"
        ),
        Circuit(
            id = 12,
            name = "Circuit Zandvoort",
            city = "Zandvoort",
            country = "Netherlands"
        ),
        Circuit(
            id = 13,
            name = "Autodromo Nazionale Monza",
            city = "Monza",
            country = "Italy"
        ),
        Circuit(
            id = 14,
            name = "Baku City Circuit",
            city = "Baku",
            country = "Azerbaijan"
        ),
        Circuit(
            id = 15,
            name = "Marina Bay Street Circuit",
            city = "Singapore",
            country = "Singapore"
        ),
        Circuit(
            id = 16,
            name = "Circuit of the Americas",
            city = "Austin",
            country = "United States"
        ),
        Circuit(
            id = 17,
            name = "Autodromo Hermanos Rodriguez",
            city = "Mexico City",
            country = "Mexico"
        ),
        Circuit(
            id = 18,
            name = "Interlagos",
            city = "São Paulo",
            country = "Brazil"
        ),
        Circuit(
            id = 19,
            name = "Las Vegas Strip Circuit",
            city = "Las Vegas",
            country = "United States"
        ),
        Circuit(
            id = 20,
            name = "Lusail International Circuit",
            city = "Lusail",
            country = "Qatar"
        )
    )

    private val races = listOf(
        Race(
            id = 1,
            name = "Bahrain Grand Prix",
            circuitId = 1,
            circuitName = "Bahrain International Circuit",
            city = "Sakhir",
            country = "Bahrain",
            date = "2026-03-08",
            round = 1
        ),
        Race(
            id = 2,
            name = "Saudi Arabian Grand Prix",
            circuitId = 2,
            circuitName = "Jeddah Corniche Circuit",
            city = "Jeddah",
            country = "Saudi Arabia",
            date = "2026-03-15",
            round = 2
        ),
        Race(
            id = 3,
            name = "Australian Grand Prix",
            circuitId = 3,
            circuitName = "Albert Park Circuit",
            city = "Melbourne",
            country = "Australia",
            date = "2026-03-29",
            round = 3
        ),
        Race(
            id = 4,
            name = "Japanese Grand Prix",
            circuitId = 4,
            circuitName = "Suzuka International Racing Course",
            city = "Suzuka",
            country = "Japan",
            date = "2026-04-12",
            round = 4
        ),
        Race(
            id = 5,
            name = "Monaco Grand Prix",
            circuitId = 5,
            circuitName = "Circuit de Monaco",
            city = "Monte Carlo",
            country = "Monaco",
            date = "2026-05-24",
            round = 5
        ),
        Race(
            id = 6,
            name = "Canadian Grand Prix",
            circuitId = 6,
            circuitName = "Circuit Gilles Villeneuve",
            city = "Montreal",
            country = "Canada",
            date = "2026-06-07",
            round = 6
        ),
        Race(
            id = 7,
            name = "Spanish Grand Prix",
            circuitId = 7,
            circuitName = "Circuit de Barcelona-Catalunya",
            city = "Barcelona",
            country = "Spain",
            date = "2026-06-14",
            round = 7
        ),
        Race(
            id = 8,
            name = "Austrian Grand Prix",
            circuitId = 8,
            circuitName = "Red Bull Ring",
            city = "Spielberg",
            country = "Austria",
            date = "2026-06-28",
            round = 8
        ),
        Race(
            id = 9,
            name = "British Grand Prix",
            circuitId = 9,
            circuitName = "Silverstone Circuit",
            city = "Silverstone",
            country = "United Kingdom",
            date = "2026-07-05",
            round = 9
        ),
        Race(
            id = 10,
            name = "Belgian Grand Prix",
            circuitId = 10,
            circuitName = "Circuit de Spa-Francorchamps",
            city = "Spa",
            country = "Belgium",
            date = "2026-07-19",
            round = 10
        ),
        Race(
            id = 11,
            name = "Hungarian Grand Prix",
            circuitId = 11,
            circuitName = "Hungaroring",
            city = "Budapest",
            country = "Hungary",
            date = "2026-07-26",
            round = 11
        ),
        Race(
            id = 12,
            name = "Dutch Grand Prix",
            circuitId = 12,
            circuitName = "Circuit Zandvoort",
            city = "Zandvoort",
            country = "Netherlands",
            date = "2026-08-23",
            round = 12
        ),
        Race(
            id = 13,
            name = "Italian Grand Prix",
            circuitId = 13,
            circuitName = "Autodromo Nazionale Monza",
            city = "Monza",
            country = "Italy",
            date = "2026-09-06",
            round = 13
        ),
        Race(
            id = 14,
            name = "Azerbaijan Grand Prix",
            circuitId = 14,
            circuitName = "Baku City Circuit",
            city = "Baku",
            country = "Azerbaijan",
            date = "2026-09-20",
            round = 14
        ),
        Race(
            id = 15,
            name = "Singapore Grand Prix",
            circuitId = 15,
            circuitName = "Marina Bay Street Circuit",
            city = "Singapore",
            country = "Singapore",
            date = "2026-10-04",
            round = 15
        ),
        Race(
            id = 16,
            name = "United States Grand Prix",
            circuitId = 16,
            circuitName = "Circuit of the Americas",
            city = "Austin",
            country = "United States",
            date = "2026-10-25",
            round = 16
        ),
        Race(
            id = 17,
            name = "Mexico City Grand Prix",
            circuitId = 17,
            circuitName = "Autodromo Hermanos Rodriguez",
            city = "Mexico City",
            country = "Mexico",
            date = "2026-11-01",
            round = 17
        ),
        Race(
            id = 18,
            name = "São Paulo Grand Prix",
            circuitId = 18,
            circuitName = "Interlagos",
            city = "São Paulo",
            country = "Brazil",
            date = "2026-11-08",
            round = 18
        ),
        Race(
            id = 19,
            name = "Las Vegas Grand Prix",
            circuitId = 19,
            circuitName = "Las Vegas Strip Circuit",
            city = "Las Vegas",
            country = "United States",
            date = "2026-11-21",
            round = 19
        ),
        Race(
            id = 20,
            name = "Qatar Grand Prix",
            circuitId = 20,
            circuitName = "Lusail International Circuit",
            city = "Lusail",
            country = "Qatar",
            date = "2026-11-29",
            round = 20
        )
    )

    private val drivers = listOf(
        Driver(
            id = 1,
            firstName = "Max",
            lastName = "Verstappen",
            number = 3
        ),
        Driver(
            id = 2,
            firstName = "Lando",
            lastName = "Norris",
            number = 1
        ),
        Driver(
            id = 3,
            firstName = "Charles",
            lastName = "Leclerc",
            number = 16
        ),
        Driver(
            id = 4,
            firstName = "Lewis",
            lastName = "Hamilton",
            number = 44
        ),
        Driver(
            id = 5,
            firstName = "Oscar",
            lastName = "Piastri",
            number = 81
        )
    )

    override suspend fun getRaces(): List<Race> {
        return races
    }

    override suspend fun getRaceDetails(id: Int): RaceDetails? {
        val race = races.find { it.id == id } ?: return null

        val circuit = circuits.find {
            it.id == race.circuitId
        } ?: return null

        return RaceDetails(
            race = race,
            circuit = circuit,
            drivers = drivers
        )
    }

    override suspend fun getCircuit(id: Int): Circuit? {
        return circuits.find { it.id == id }
    }

    override suspend fun getDrivers(): List<Driver> {
        return drivers
    }
}