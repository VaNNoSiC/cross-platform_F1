package com.example.apex

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform