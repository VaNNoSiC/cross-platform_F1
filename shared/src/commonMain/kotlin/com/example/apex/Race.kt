package com.example.apex

data class Race(
    val id: Int,
    val name: String,
    val circuitId: Int,
    val circuitName: String,
    val city: String,
    val country: String,
    val date: String,
    val round: Int
)