
package com.example.apex

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.util.Properties

private fun loadWindowTitle(): String {
    val properties = Properties()

    val stream = object {}.javaClass
        .getResourceAsStream("/desktop.properties")

    if (stream != null) {
        stream.use { properties.load(it) }
    }

    return properties.getProperty("app.title", "Apex Archive")
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = loadWindowTitle()
    ) {
        App()
    }
}