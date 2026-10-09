package com.example.apex

import java.util.Locale

actual fun setAppLanguage(language: String) {
    Locale.setDefault(Locale.forLanguageTag(language))
}