package com.example.apex

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf

actual object LocalAppLocale {
    private val localLocale = staticCompositionLocalOf { "en" }

    actual val current: String
        @Composable get() = localLocale.current

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        return localLocale provides (value ?: "en")
    }
}